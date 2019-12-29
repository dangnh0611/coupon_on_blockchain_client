package Utils;

import ContractWrapper.Campain;
import ContractWrapper.CampainFactory;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Hash;
import org.web3j.crypto.Sign;
import org.web3j.protocol.Web3j;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.Collections;

import static org.web3j.tx.gas.DefaultGasProvider.GAS_LIMIT;
import static org.web3j.tx.gas.DefaultGasProvider.GAS_PRICE;

public class Utils {

    private Web3j web3j;
    private Credentials credentials;

    public Utils(Web3j web3j, Credentials credentials){
        this.web3j=web3j;
        this.credentials=credentials;
    }

    public Campain loadCampain(String address){
        return Campain.load(address, web3j, credentials, BigInteger.valueOf(8000000000L), BigInteger.valueOf(500000L) );
    }

    public CampainFactory loadFactory(String address){
        return CampainFactory.load(address, web3j, credentials, BigInteger.valueOf(8000000000L), BigInteger.valueOf(700000L) );
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static String byteArrayToHexString(byte[] byteArr){
        StringBuilder sb = new StringBuilder();
        for (byte b : byteArr) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
