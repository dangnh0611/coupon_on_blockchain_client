package Utils;

import ContractWrapper.Campain;
import ContractWrapper.CampainFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import java.math.BigInteger;

public class Utils {

    private Web3j web3j;
    private Credentials credentials;
    public final BigInteger DEFAULT_GASPRICE= BigInteger.valueOf(6L);
    public final BigInteger DEFAULT_GASLIMIT= BigInteger.valueOf(500000L);

    public Utils(Web3j web3j, Credentials credentials){
        this.web3j=web3j;
        this.credentials=credentials;
    }

    public Campain loadCampain(String address){
        return Campain.load(address, web3j, credentials, BigInteger.valueOf(8L), BigInteger.valueOf(500000L));
    }

    public CampainFactory loadFactory(String address){
        return CampainFactory.load(address, web3j, credentials, BigInteger.valueOf(8L), BigInteger.valueOf(5000000L));
    }
}
