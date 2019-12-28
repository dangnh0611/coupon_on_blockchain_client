import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import ContractWrapper.Campain;
import ContractWrapper.CampainFactory;
import Roles.Issuer;
import io.reactivex.Flowable;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthLog;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.tx.Contract;

import static org.web3j.tx.Transfer.GAS_LIMIT;
import static org.web3j.tx.gas.DefaultGasProvider.GAS_PRICE;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start..");
        Issuer iss = new Issuer("d7c2467297b410e676dc1c0bf58e1e6ef9892d05290d48c0a71d6f6207cf92ff");

        // Tạo campain mới
//        iss.createCampain(10,false, 2,"Campain2", "food", "sale off 50% all food at REGR", 100);

        // Lấy danh sách các campain mà issuer đã tạo.
//        for(CampainFactory.NewCampainEventResponse e: iss.getOwnedCampains()){
//            System.out.println("Campain Address: "+e._address);
//            System.out.println("Campain Name: "+e._name);
//            System.out.println("Campain_Description: "+e._description);
//            System.out.println("Campain Num_coupons: " + e._num_coupon);
//            System.out.println("Campain Endtime: "+ e._end_time);
//            System.out.println("--------------------------------");
//        }

        // Lấy danh sách thông tin các distributor tham gia vào một campain.
//        for(Issuer.Distributor dis: iss.getOwnedDistributors("0x6B7EF57989E01E7e3825622669f20af06fdf2B8b")){
//            System.out.println(dis.address+"  "+dis.num_redeemed+"  "+ dis.num_acquired);
//            System.out.println("-------------------------------");
//        }

        // Thêm distributor.
//        iss.addDistributor("0xf23a159Fc06FfbedF103BA67905000E18b26B734","0xf3A566312478c62e05B1958020B3e837C8E21B42");

        // Xóa distributor.
        iss.removeDistributor("0xf23a159Fc06FfbedF103BA67905000E18b26B734","0xf3A566312478c62e05B1958020B3e837C8E21B42");
            System.out.println("End!");
    }
}
