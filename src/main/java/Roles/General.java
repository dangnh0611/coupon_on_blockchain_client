package Roles;

import ContractWrapper.Campain;
import ContractWrapper.CampainFactory;
import Utils.Utils;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.websocket.WebSocketService;

import java.math.BigInteger;

public class General {
    protected String private_key;
    protected String address;
    protected final String infura_url="https://ropsten.infura.io/v3/8f21cada4d3d48db8e74bd7643afad9c";
    protected final String factory_address="0x14B9a9Da15905c6cE4048908C7150AEDB1e68DF8";
    protected Credentials credentials;
    protected Web3j web3j;
    protected Utils utils;
    protected CampainFactory factory;

    public General(String _private_key){
        this.private_key=_private_key;
        this.credentials = Credentials.create(this.private_key);
        this.address=credentials.getAddress();
        WebSocketService web3jService = new WebSocketService("wss://ropsten.infura.io/ws/v3/8f21cada4d3d48db8e74bd7643afad9c",true);
        try {
            web3jService.connect();
        }
        catch (Exception e){
            System.out.println("Error on connect to Infura web socket.");
        }
        this.web3j = Web3j.build(web3jService);
        this.utils = new Utils(this.web3j, this.credentials);
        this.factory= utils.loadFactory(this.factory_address);
    }

}
