package Roles;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.Hash;
import org.web3j.crypto.Sign;
import Utils.Utils;

public class Distributor extends General {
    public Distributor(String _private_key) {
        super(_private_key);
    }

    public String generateQRForBearer(String campain_address, String bearer_address){
        byte[] campain = Utils.hexStringToByteArray(campain_address.substring(2));
        byte[] address = Utils.hexStringToByteArray(bearer_address.substring(2));
        System.out.println(campain.length+address.length);
        byte[] msg = new byte[64];
        System.arraycopy(address,0,msg,12,20);
        System.arraycopy(campain, 0,msg,44,20);
        byte[] hash = Hash.sha3(msg);
        String hash_str = Utils.byteArrayToHexString(hash);
        System.out.println(hash_str);
        Sign.SignatureData sig = Sign.signMessage(hash, Credentials.create(this.private_key).getEcKeyPair(), false);
        String v_str = Utils.byteArrayToHexString(sig.getV());
        String r_str = Utils.byteArrayToHexString(sig.getR());
        String s_str = Utils.byteArrayToHexString(sig.getS());
        String qr_text = campain_address + " " +this.address +" "+ hash_str +" "+ v_str +" "+ r_str +" "+ s_str;
        System.out.println(qr_text);
        return qr_text;
    }
}