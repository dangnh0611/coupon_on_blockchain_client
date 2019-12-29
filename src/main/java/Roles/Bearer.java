package Roles;

import ContractWrapper.Campain;
import ContractWrapper.CampainFactory;
import Utils.Utils;
import io.reactivex.disposables.Disposable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Hash;
import org.web3j.crypto.Sign;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;

import java.math.BigInteger;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;

public class Bearer extends General {
    public Bearer(String _private_key){
        super(_private_key);
    }

    // Trả về tất cả các campains mà bearer đã nhận được coupons, có thể sử dụng tại quầy.
    public List<CampainInfo> getAllAcquiredCampains() throws Exception {

        EthFilter filter =
                new EthFilter(
                        DefaultBlockParameterName.EARLIEST,
                        DefaultBlockParameterName.LATEST,
                        this.factory_address).addSingleTopic(EventEncoder.encode(CampainFactory.ACQUIRE_EVENT)).addOptionalTopics("0x000000000000000000000000"+this.address.substring(2));
        List<CampainInfo> campain_infos= new ArrayList<CampainInfo>();
        Disposable sub = this.factory.acquireEventFlowable(filter).subscribe(event->{
            String campain_addr=event._campain;
            Campain cp = this.utils.loadCampain(campain_addr);
            List<BigInteger> status= cp.get_campain_status().sendAsync().get();
            campain_infos.add(new CampainInfo(
                    campain_addr,
                    cp.get_campain_name().sendAsync().get(),
                    cp.get_campain_category().sendAsync().get(),
                    cp.get_campain_description().sendAsync().get(),
                    cp.get_campain_endtime().sendAsync().get().longValue(),
                    status.get(0).longValue(),
                    status.get(1).longValue(),
                    status.get(2).longValue()));
        });
        sub.dispose();
        return campain_infos;
    }

    public void aquire(String qr_text) throws  Exception {
        String[] splited = qr_text.split("\\s+");
        String campain_address = splited[0];
        String distributor_address = splited[1];
        byte[] hash = Utils.hexStringToByteArray(splited[2]);
        byte[] v = Utils.hexStringToByteArray(splited[3]);
        byte[] r = Utils.hexStringToByteArray(splited[4]);
        byte[] s = Utils.hexStringToByteArray(splited[5]);
        this.utils.loadCampain(campain_address).acquire(hash,new BigInteger(1, v),new BigInteger(1, r),
                new BigInteger(1, s), distributor_address)
                .sendAsync().get();
    }




}
