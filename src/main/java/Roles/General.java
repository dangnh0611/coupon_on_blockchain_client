package Roles;

import ContractWrapper.Campain;
import ContractWrapper.CampainFactory;
import Utils.Utils;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

public class General {
    private String private_key;
    private final String infura_url="https://ropsten.infura.io/v3/8f21cada4d3d48db8e74bd7643afad9c";
    protected final String factory_address="0xa5f4629592FdFB6bb5F7De038E53d01471d56A53";
    private Credentials credentials;
    protected Web3j web3j;
    protected Utils utils;
    protected CampainFactory factory;

    public General(String _private_key){
        this.private_key=_private_key;
        this.credentials = Credentials.create(this.private_key);
        this.web3j = Web3j.build(new HttpService(this.infura_url));
        this.utils = new Utils(this.web3j, this.credentials);
        this.factory= utils.loadFactory(this.factory_address);
    }

}
