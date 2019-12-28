package ContractWrapper;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.StaticArray2;
import org.web3j.abi.datatypes.generated.StaticArray3;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class Campain extends Contract {
    private static final String BINARY = "0x740100000000000000000000000000000000000000006020526f7fffffffffffffffffffffffffffffff6040527fffffffffffffffffffffffffffffffff8000000000000000000000000000000060605274012a05f1fffffffffffffffffffffffffdabf41c006080527ffffffffffffffffffffffffed5fa0e000000000000000000000000000000000060a05261010061178861014039602061178860c03960c05160205181106100b057600080fd5b50602060206117880160c03960c051600281106100cc57600080fd5b506052602060a06117880160c03960c05161178801610240396032602060a06117880160c03960c05160040135111561010457600080fd5b6034602060c06117880160c03960c051611788016102c0396014602060c06117880160c03960c05160040135111561013b57600080fd5b6084602060e06117880160c03960c05161178801610320396064602060e06117880160c03960c05160040135111561017257600080fd5b60016000556101a05115156101885760006101ae565b610180516101a051610180516101a0510204146101a457600080fd5b610180516101a051025b6008556008543410156101c057600080fd5b61024080600b60c052602060c020602082510161012060006003818352015b826101205160200211156101f257610214565b61012051602002850151610120518501555b81516001018083528114156101df575b5050505050506102c080600c60c052602060c020602082510161012060006002818352015b8261012051602002111561024c5761026e565b61012051602002850151610120518501555b8151600101808352811415610239575b50505050505061032080600d60c052602060c020602082510161012060006005818352015b826101205160200211156102a6576102c8565b61012051602002850151610120518501555b8151600101808352811415610293575b50505050505061016051600e556101c05160075561014051600355610180516004556101a051600255600454600555600960c052602060c02060c052602060c02061014051815560006001820155600060028201556000600382015550600060015561177056600035601c52740100000000000000000000000000000000000000006020526f7fffffffffffffffffffffffffffffff6040527fffffffffffffffffffffffffffffffff8000000000000000000000000000000060605274012a05f1fffffffffffffffffffffffffdabf41c006080527ffffffffffffffffffffffffed5fa0e000000000000000000000000000000000060a05263aff3574960005114156102cf5760043560205181106100b257600080fd5b50602435600281106100c357600080fd5b50605260a43560040161014037603260a4356004013511156100e457600080fd5b603460c4356004016101c037601460c43560040135111561010457600080fd5b608460e43560040161022037606460e43560040135111561012457600080fd5b6000541561013157600080fd5b60016000556064351515610146576000610166565b60443560643560443560643502041461015e57600080fd5b604435606435025b60085561014080600b60c052602060c020602082510161012060006003818352015b8261012051602002111561019b576101bd565b61012051602002850151610120518501555b8151600101808352811415610188575b5050505050506101c080600c60c052602060c020602082510161012060006002818352015b826101205160200211156101f557610217565b61012051602002850151610120518501555b81516001018083528114156101e2575b50505050505061022080600d60c052602060c020602082510161012060006005818352015b8261012051602002111561024f57610271565b61012051602002850151610120518501555b815160010180835281141561023c575b505050505050602435600e55608435600755600435600355604435600455606435600255600454600555600960c052602060c02060c052602060c0206004358155600060018201556000600282015560006003820155506001600155005b636567dc4a60005114156103175734156102e857600080fd5b600435603281106102f857600080fd5b600960c052602060c0200160c052602060c0205460005260206000f350005b63d1e9b84b600051141561039257341561033057600080fd5b61016060016004356032811061034557600080fd5b600960c052602060c0200160c052602060c0200154815260026004356032811061036e57600080fd5b600960c052602060c0200160c052602060c02001548160200152506040610160f350005b63ee53dd1b60005114156103dd5734156103ab57600080fd5b6003600435603281106103bd57600080fd5b600960c052602060c0200160c052602060c020015460005260206000f350005b6399a9fa0d60005114156104af5734156103f657600080fd5b600b8060c052602060c020610180602082540161012060006003818352015b826101205160200211156104285761044a565b61012051850154610120516020028501525b8151600101808352811415610415575b505050505050610200610180516040818352015b604061020051111561046f5761048b565b6000610200516101a001535b815160010180835281141561045e575b50506020610160526040610180510160206001820306601f8201039050610160f350005b63ead922f660005114156105815734156104c857600080fd5b600c8060c052602060c020610180602082540161012060006002818352015b826101205160200211156104fa5761051c565b61012051850154610120516020028501525b81516001018083528114156104e7575b5050505050506101e0610180516020818352015b60206101e05111156105415761055d565b60006101e0516101a001535b8151600101808352811415610530575b50506020610160526040610180510160206001820306601f8201039050610160f350005b635e2e06a6600051141561065357341561059a57600080fd5b600d8060c052602060c020610180602082540161012060006005818352015b826101205160200211156105cc576105ee565b61012051850154610120516020028501525b81516001018083528114156105b9575b505050505050610240610180516080818352015b60806102405111156106135761062f565b6000610240516101a001535b8151600101808352811415610602575b50506020610160526040610180510160206001820306601f8201039050610160f350005b63f20e39a4600051141561067a57341561066c57600080fd5b60075460005260206000f350005b636eecf74f60005114156106a157341561069357600080fd5b60025460005260206000f350005b63b112368160005114156106dc5734156106ba57600080fd5b610160600454815260055481602001526006548160400152506060610160f350005b636d484f0260005114156108905734156106f557600080fd5b600435602051811061070657600080fd5b50600354331461071557600080fd5b60326001541061072457600080fd5b7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff6101405261016060006032818352015b600435610160516032811061076957600080fd5b600960c052602060c0200160c052602060c020541861078757600080fd5b610160516032811061079857600080fd5b600960c052602060c0200160c052602060c02054157fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff610140511416156107e25761016051610140525b5b8151600101808352811415610755575b50507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff61014051181561088e57610140516032811061083157600080fd5b600960c052602060c0200160c052602060c020600435815560006001820155600060028201556000600382015550600435610180527f3afd547f7eb357741de51229846ae795cb06449e4b4032eb34a7cc0a751e25c16020610180a15b005b63770cec2360005114156109b75734156108a957600080fd5b60043560205181106108ba57600080fd5b5060035433146108c957600080fd5b61014060006032818352015b60043561014051603281106108e957600080fd5b600960c052602060c0200160c052602060c0205414156109a2576001610140516032811061091657600080fd5b600960c052602060c0200160c052602060c02001541561093557600080fd5b610140516032811061094657600080fd5b600960c052602060c0200160c052602060c0206000815560006001820155600060028201556000600382015550600435610160527f43dd2f8ce4e5873e618ffabcae9856729ea5811dbc5e1c9be4365fcf7b7cf7036020610160a15b5b81516001018083528114156108d5575b5050005b633ac442286000511415610b0e5734156109d057600080fd5b60043560205181106109e157600080fd5b506007544211156109f157600080fd5b600a60043560e05260c052604060c02060c052602060c0205415610a1457600080fd5b600a3360e05260c052604060c02060c052602060c02054610a3457600080fd5b6001600a3360e05260c052604060c02060c052602060c020015415610a5857600080fd5b6002600a3360e05260c052604060c02060c052602060c020015415610a7c57600080fd5b60016001600a3360e05260c052604060c02060c052602060c0200155600a60043560e05260c052604060c02060c052602060c0206001815560006001820155600060028201556003600a3360e05260c052604060c02060c052602060c0200154600382015550600435337fd68f762a17db414b31522c40e5e9dc14fda19c0aebd316223bc821d7cb0e7f1360006000a3005b600015610c38575b6101805261014052610160526005600181541015610b3357600080fd5b60018154038155506101a060006032818352015b610160516101a05160328110610b5c57600080fd5b600960c052602060c0200160c052602060c020541415610bbc5760016101a05160328110610b8957600080fd5b600960c052602060c0200160c052602060c02001805460018254011015610baf57600080fd5b6001815401815550610bcd565b5b8151600101808352811415610b47575b5050600a6101405160e05260c052604060c02060c052602060c0206001815560006001820155600060028201556101605160038201555061016051610140517f917b6d640fc6e2a6574871a567f3f7a29df9202d11b163f27c268ced8921fe3560006000a361018051565b600015610d4f575b6101805261014052610160526006805460018254011015610c6057600080fd5b60018154018155506101a060006032818352015b610160516101a05160328110610c8957600080fd5b600960c052602060c0200160c052602060c020541415610ce95760026101a05160328110610cb657600080fd5b600960c052602060c0200160c052602060c02001805460018254011015610cdc57600080fd5b6001815401815550610cfa565b5b8151600101808352811415610c74575b505060016002600a6101405160e05260c052604060c02060c052602060c020015561016051610140517f2f39d8fc9160ae00ea6a02229ae376184d7ad48d669c511863fedeb3f6f27edf60006000a361018051565b633ccfd60b6000511415610f66573415610d6857600080fd5b600060025411610d7757600080fd5b61014060006032818352015b336101405160328110610d9557600080fd5b600960c052602060c0200160c052602060c020541415610f4d5760026101405160328110610dc257600080fd5b600960c052602060c0200160c052602060c0200154610160526000610160511115610f4c5760036101405160328110610dfa57600080fd5b600960c052602060c0200160c052602060c02001546002541515610e1f576000610e42565b6101605160025461016051600254020414610e3957600080fd5b61016051600254025b1015610e4d57600080fd5b60036101405160328110610e6057600080fd5b600960c052602060c0200160c052602060c02001546002541515610e85576000610ea8565b6101605160025461016051600254020414610e9f57600080fd5b61016051600254025b036101805260006101805111610ebd57600080fd5b600060006000600061018051336000f1610ed657600080fd5b610180516101a052337fad600bfdaa27b1936022a8954698af115bfceff5dab89ff9d99521f8e3d1ab1460206101a0a260036101405160328110610f1957600080fd5b600960c052602060c0200160c052602060c020018054610180518254011015610f4157600080fd5b610180518154018155505b5b610f62565b8151600101808352811415610d83575b5050005b63635cd1686000511415610ff4573415610f7f57600080fd5b6007544211610f8d57600080fd5b6003543314610f9b57600080fd5b600060085411610faa57600080fd5b60006000600060006008546003546000f1610fc457600080fd5b600854610140527f2e1897b0591d764356194f7a795238a87c1987c7a877568e50d829d547c92b976020610140a1005b630f14c78d600051141561106457341561100d57600080fd5b60075442111561101c57600080fd5b600354331861102a57600080fd5b60006005541161103957600080fd5b634e77c31561014052336101605260035461018052610180516101605160065801610b16565b600050005b63b99e282a600051141561126b57341561107d57600080fd5b608435602051811061108e57600080fd5b5060075442111561109e57600080fd5b6000600554116110ad57600080fd5b60006101405261016060006032818352015b60843561016051603281106110d357600080fd5b600960c052602060c0200160c052602060c0205414156110f857600161014052611109565b5b81516001018083528114156110bf575b50506101405161111857600080fd5b600354331861112657600080fd5b60003360208261018001015260208101905030602082610180010152602081019050806101805261018090508051602082012090506004351461116857600080fd5b600a3360e05260c052604060c02060c052602060c020541561118957600080fd5b6001600a3360e05260c052604060c02060c052602060c0200154156111ad57600080fd5b60843560043561020052602435610220526044356102405260643561026052602060c0608061020060006001610bb8f15060c051146111eb57600080fd5b6101406102c0525b6102c0515160206102c051016102c0526102c06102c0511015611215576111f3565b634e77c3156102e052336103005260843561032052610320516103005160065801610b16565b6102a06102c0525b6102c0515260206102c051036102c0526101406102c05110151561126657611243565b600050005b63a814c1fe600051141561143b57341561128457600080fd5b600435602051811061129557600080fd5b506007544211156112a557600080fd5b600354600435186112b557600080fd5b60006004356020826101400101526020810190503060208261014001015260208101905080610140526101409050805160208201209050602435146112f957600080fd5b6001600a60043560e05260c052604060c02060c052602060c02001541561131f57600080fd5b600a60043560e05260c052604060c02060c052602060c0205461134157600080fd5b6002600a60043560e05260c052604060c02060c052602060c02001541561136757600080fd5b6004356024356101c0526044356101e0526064356102005260843561022052602060c060806101c060006001610bb8f15060c051146113a557600080fd5b6101405161016051610180516101a0516101c0516101e051610200516102205161024051610260516357d4f7766102a0526004356102c0526003600a60043560e05260c052604060c02060c052602060c02001546102e0526102e0516102c05160065801610c40565b610260526102405261022052610200526101e0526101c0526101a052610180526101605261014052600050005b60006000fd5b61032f6117700361032f60003961032f611770036000f3\n";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_GET_DISTRIBUTORS_ADDRESS = "get_distributors_address";

    public static final String FUNC_GET_DISTRIBUTORS_STATUS = "get_distributors_status";

    public static final String FUNC_GET_DISTRIBUTORS_WITHDRAWED = "get_distributors_withdrawed";

    public static final String FUNC_GET_CAMPAIN_NAME = "get_campain_name";

    public static final String FUNC_GET_CAMPAIN_CATEGORY = "get_campain_category";

    public static final String FUNC_GET_CAMPAIN_DESCRIPTION = "get_campain_description";

    public static final String FUNC_GET_CAMPAIN_ENDTIME = "get_campain_endtime";

    public static final String FUNC_GET_WEI_PER_REDEEMED = "get_wei_per_redeemed";

    public static final String FUNC_GET_CAMPAIN_STATUS = "get_campain_status";

    public static final String FUNC_ADD_DISTRIBUTOR = "add_distributor";

    public static final String FUNC_REMOVE_DISTRIBUTOR = "remove_distributor";

    public static final String FUNC_TRANSFER_COUPON = "transfer_coupon";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_FINAL_REFUND = "final_refund";

    public static final String FUNC_FREE_ACQUIRE_FROM_ISSUER = "free_acquire_from_issuer";

    public static final String FUNC_ACQUIRE = "acquire";

    public static final String FUNC_REDEEM = "redeem";

    public static final Event ADDDISTRIBUTOR_EVENT = new Event("AddDistributor", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event REMOVEDISTRIBUTOR_EVENT = new Event("RemoveDistributor", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event TRANSFERBEARER_EVENT = new Event("TransferBearer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event ACQUIRE_EVENT = new Event("Acquire", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event REDEEM_EVENT = new Event("Redeem", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event GETSALARY_EVENT = new Event("GetSalary", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event REFUND_EVENT = new Event("Refund", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Campain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Campain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Campain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Campain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddDistributorEventResponse> getAddDistributorEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDDISTRIBUTOR_EVENT, transactionReceipt);
        ArrayList<AddDistributorEventResponse> responses = new ArrayList<AddDistributorEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddDistributorEventResponse typedResponse = new AddDistributorEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._distributor = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddDistributorEventResponse> addDistributorEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddDistributorEventResponse>() {
            @Override
            public AddDistributorEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDDISTRIBUTOR_EVENT, log);
                AddDistributorEventResponse typedResponse = new AddDistributorEventResponse();
                typedResponse.log = log;
                typedResponse._distributor = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddDistributorEventResponse> addDistributorEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDDISTRIBUTOR_EVENT));
        return addDistributorEventFlowable(filter);
    }

    public List<RemoveDistributorEventResponse> getRemoveDistributorEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REMOVEDISTRIBUTOR_EVENT, transactionReceipt);
        ArrayList<RemoveDistributorEventResponse> responses = new ArrayList<RemoveDistributorEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RemoveDistributorEventResponse typedResponse = new RemoveDistributorEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._distributor = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RemoveDistributorEventResponse> removeDistributorEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RemoveDistributorEventResponse>() {
            @Override
            public RemoveDistributorEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REMOVEDISTRIBUTOR_EVENT, log);
                RemoveDistributorEventResponse typedResponse = new RemoveDistributorEventResponse();
                typedResponse.log = log;
                typedResponse._distributor = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RemoveDistributorEventResponse> removeDistributorEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REMOVEDISTRIBUTOR_EVENT));
        return removeDistributorEventFlowable(filter);
    }

    public List<TransferBearerEventResponse> getTransferBearerEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFERBEARER_EVENT, transactionReceipt);
        ArrayList<TransferBearerEventResponse> responses = new ArrayList<TransferBearerEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferBearerEventResponse typedResponse = new TransferBearerEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferBearerEventResponse> transferBearerEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferBearerEventResponse>() {
            @Override
            public TransferBearerEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFERBEARER_EVENT, log);
                TransferBearerEventResponse typedResponse = new TransferBearerEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferBearerEventResponse> transferBearerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFERBEARER_EVENT));
        return transferBearerEventFlowable(filter);
    }

    public List<AcquireEventResponse> getAcquireEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ACQUIRE_EVENT, transactionReceipt);
        ArrayList<AcquireEventResponse> responses = new ArrayList<AcquireEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AcquireEventResponse typedResponse = new AcquireEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._address = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._distributor = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AcquireEventResponse> acquireEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AcquireEventResponse>() {
            @Override
            public AcquireEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ACQUIRE_EVENT, log);
                AcquireEventResponse typedResponse = new AcquireEventResponse();
                typedResponse.log = log;
                typedResponse._address = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._distributor = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AcquireEventResponse> acquireEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ACQUIRE_EVENT));
        return acquireEventFlowable(filter);
    }

    public List<RedeemEventResponse> getRedeemEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REDEEM_EVENT, transactionReceipt);
        ArrayList<RedeemEventResponse> responses = new ArrayList<RedeemEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RedeemEventResponse typedResponse = new RedeemEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._address = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._distributor = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RedeemEventResponse> redeemEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RedeemEventResponse>() {
            @Override
            public RedeemEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REDEEM_EVENT, log);
                RedeemEventResponse typedResponse = new RedeemEventResponse();
                typedResponse.log = log;
                typedResponse._address = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._distributor = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RedeemEventResponse> redeemEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REDEEM_EVENT));
        return redeemEventFlowable(filter);
    }

    public List<GetSalaryEventResponse> getGetSalaryEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(GETSALARY_EVENT, transactionReceipt);
        ArrayList<GetSalaryEventResponse> responses = new ArrayList<GetSalaryEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            GetSalaryEventResponse typedResponse = new GetSalaryEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._address = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<GetSalaryEventResponse> getSalaryEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, GetSalaryEventResponse>() {
            @Override
            public GetSalaryEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(GETSALARY_EVENT, log);
                GetSalaryEventResponse typedResponse = new GetSalaryEventResponse();
                typedResponse.log = log;
                typedResponse._address = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<GetSalaryEventResponse> getSalaryEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(GETSALARY_EVENT));
        return getSalaryEventFlowable(filter);
    }

    public List<RefundEventResponse> getRefundEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REFUND_EVENT, transactionReceipt);
        ArrayList<RefundEventResponse> responses = new ArrayList<RefundEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RefundEventResponse typedResponse = new RefundEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RefundEventResponse> refundEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RefundEventResponse>() {
            @Override
            public RefundEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REFUND_EVENT, log);
                RefundEventResponse typedResponse = new RefundEventResponse();
                typedResponse.log = log;
                typedResponse._amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RefundEventResponse> refundEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REFUND_EVENT));
        return refundEventFlowable(filter);
    }

    public RemoteCall<TransactionReceipt> initialize(String _issuer, Boolean _is_free_from_issuer, BigInteger _num_coupons, BigInteger _wei_per_redeemtion, BigInteger _end_time, String _name, String _category, String _description, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_issuer), 
                new org.web3j.abi.datatypes.Bool(_is_free_from_issuer), 
                new org.web3j.abi.datatypes.generated.Uint256(_num_coupons), 
                new org.web3j.abi.datatypes.generated.Uint256(_wei_per_redeemtion), 
                new org.web3j.abi.datatypes.generated.Uint256(_end_time), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_category), 
                new org.web3j.abi.datatypes.Utf8String(_description)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<String> get_distributors_address(BigInteger _idx) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET_DISTRIBUTORS_ADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<List> get_distributors_status(BigInteger _idx) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET_DISTRIBUTORS_STATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<BigInteger> get_distributors_withdrawed(BigInteger _idx) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET_DISTRIBUTORS_WITHDRAWED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> get_campain_name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET_CAMPAIN_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> get_campain_category() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET_CAMPAIN_CATEGORY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> get_campain_description() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET_CAMPAIN_DESCRIPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> get_campain_endtime() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET_CAMPAIN_ENDTIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> get_wei_per_redeemed() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET_WEI_PER_REDEEMED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<List> get_campain_status() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET_CAMPAIN_STATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray3<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<TransactionReceipt> add_distributor(String _new_distributor) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADD_DISTRIBUTOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_new_distributor)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> remove_distributor(String _target_distributor) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REMOVE_DISTRIBUTOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_target_distributor)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transfer_coupon(String _dest_address) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFER_COUPON, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dest_address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdraw() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> final_refund() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FINAL_REFUND, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> free_acquire_from_issuer() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FREE_ACQUIRE_FROM_ISSUER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> acquire(byte[] _hash, BigInteger v, BigInteger r, BigInteger s, String _distributor) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ACQUIRE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_hash), 
                new org.web3j.abi.datatypes.generated.Uint256(v), 
                new org.web3j.abi.datatypes.generated.Uint256(r), 
                new org.web3j.abi.datatypes.generated.Uint256(s), 
                new org.web3j.abi.datatypes.Address(_distributor)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> redeem(String _bearer, byte[] _hash, BigInteger v, BigInteger r, BigInteger s) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REDEEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_bearer), 
                new org.web3j.abi.datatypes.generated.Bytes32(_hash), 
                new org.web3j.abi.datatypes.generated.Uint256(v), 
                new org.web3j.abi.datatypes.generated.Uint256(r), 
                new org.web3j.abi.datatypes.generated.Uint256(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Campain load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Campain(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Campain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Campain(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Campain load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Campain(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Campain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Campain(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Campain> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue, String _issuer, Boolean _is_free_from_issuer, BigInteger _num_coupons, BigInteger _wei_per_redeemtion, BigInteger _end_time, String _name, String _category, String _description) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_issuer), 
                new org.web3j.abi.datatypes.Bool(_is_free_from_issuer), 
                new org.web3j.abi.datatypes.generated.Uint256(_num_coupons), 
                new org.web3j.abi.datatypes.generated.Uint256(_wei_per_redeemtion), 
                new org.web3j.abi.datatypes.generated.Uint256(_end_time), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_category), 
                new org.web3j.abi.datatypes.Utf8String(_description)));
        return deployRemoteCall(Campain.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RemoteCall<Campain> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue, String _issuer, Boolean _is_free_from_issuer, BigInteger _num_coupons, BigInteger _wei_per_redeemtion, BigInteger _end_time, String _name, String _category, String _description) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_issuer), 
                new org.web3j.abi.datatypes.Bool(_is_free_from_issuer), 
                new org.web3j.abi.datatypes.generated.Uint256(_num_coupons), 
                new org.web3j.abi.datatypes.generated.Uint256(_wei_per_redeemtion), 
                new org.web3j.abi.datatypes.generated.Uint256(_end_time), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_category), 
                new org.web3j.abi.datatypes.Utf8String(_description)));
        return deployRemoteCall(Campain.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<Campain> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String _issuer, Boolean _is_free_from_issuer, BigInteger _num_coupons, BigInteger _wei_per_redeemtion, BigInteger _end_time, String _name, String _category, String _description) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_issuer), 
                new org.web3j.abi.datatypes.Bool(_is_free_from_issuer), 
                new org.web3j.abi.datatypes.generated.Uint256(_num_coupons), 
                new org.web3j.abi.datatypes.generated.Uint256(_wei_per_redeemtion), 
                new org.web3j.abi.datatypes.generated.Uint256(_end_time), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_category), 
                new org.web3j.abi.datatypes.Utf8String(_description)));
        return deployRemoteCall(Campain.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<Campain> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String _issuer, Boolean _is_free_from_issuer, BigInteger _num_coupons, BigInteger _wei_per_redeemtion, BigInteger _end_time, String _name, String _category, String _description) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_issuer), 
                new org.web3j.abi.datatypes.Bool(_is_free_from_issuer), 
                new org.web3j.abi.datatypes.generated.Uint256(_num_coupons), 
                new org.web3j.abi.datatypes.generated.Uint256(_wei_per_redeemtion), 
                new org.web3j.abi.datatypes.generated.Uint256(_end_time), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_category), 
                new org.web3j.abi.datatypes.Utf8String(_description)));
        return deployRemoteCall(Campain.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static class AddDistributorEventResponse {
        public Log log;

        public String _distributor;
    }

    public static class RemoveDistributorEventResponse {
        public Log log;

        public String _distributor;
    }

    public static class TransferBearerEventResponse {
        public Log log;

        public String _from;

        public String _to;
    }

    public static class AcquireEventResponse {
        public Log log;

        public String _address;

        public String _distributor;
    }

    public static class RedeemEventResponse {
        public Log log;

        public String _address;

        public String _distributor;
    }

    public static class GetSalaryEventResponse {
        public Log log;

        public String _address;

        public BigInteger _amount;
    }

    public static class RefundEventResponse {
        public Log log;

        public BigInteger _amount;
    }
}
