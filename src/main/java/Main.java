import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import ContractWrapper.Campain;
import ContractWrapper.CampainFactory;
import Roles.Issuer;
import io.reactivex.Flowable;
import jdk.internal.org.objectweb.asm.Type;
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
    static String infura_url="https://ropsten.infura.io/v3/8f21cada4d3d48db8e74bd7643afad9c";
    public static void main(String[] args) throws Exception{
        System.out.println("Start..");
//        Web3j web3j = Web3j.build(new HttpService(infura_url));
//        Credentials credentials = Credentials.create("d7c2467297b410e676dc1c0bf58e1e6ef9892d05290d48c0a71d6f6207cf92ff");
//        Campain contract = Campain.load("0x248B9b1BbE41b964eC7D66f84d29bF19BB483222", web3j, credentials, BigInteger.valueOf(8L), BigInteger.valueOf(500000L));
//        System.out.println(contract.get_campain_description().send());
////        contract.add_distributor("0x2871FAFE199c6EFDD4a938387B5c0108027513be").send();
//        contract.add_distributor("0x16FA6349E3fbA711D0cE342674990a6D00aF9B18").sendAsync().get();

        Issuer iss = new Issuer("d7c2467297b410e676dc1c0bf58e1e6ef9892d05290d48c0a71d6f6207cf92ff");
//        iss.createCampain(0,false, 2,"Campain2", "food", "sale off 50% all food at REGR", 100);

        List<EthLog.LogResult> rets = iss.createFilterForEvent();
        System.out.println(rets);
        for (EthLog.LogResult ret: rets){
            System.out.println(ret);
        }

        System.out.println("End!");
    }
}
