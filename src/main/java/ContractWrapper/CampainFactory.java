package ContractWrapper;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class CampainFactory extends Contract {
    private static final String BINARY = "0x740100000000000000000000000000000000000000006020526f7fffffffffffffffffffffffffffffff6040527fffffffffffffffffffffffffffffffff8000000000000000000000000000000060605274012a05f1fffffffffffffffffffffffffdabf41c006080527ffffffffffffffffffffffffed5fa0e000000000000000000000000000000000060a052602061069a6101403934156100a157600080fd5b602061069a60c03960c05160205181106100ba57600080fd5b506101405160005561068256600035601c52740100000000000000000000000000000000000000006020526f7fffffffffffffffffffffffffffffff6040527fffffffffffffffffffffffffffffffff8000000000000000000000000000000060605274012a05f1fffffffffffffffffffffffffdabf41c006080527ffffffffffffffffffffffffed5fa0e000000000000000000000000000000000060a05263438256ee60005114156105b557602435600281106100b157600080fd5b5060526064356004016101403760326064356004013511156100d257600080fd5b60346084356004016101c03760146084356004013511156100f257600080fd5b608460a43560040161022037606460a43560040135111561011257600080fd5b60006004351161012157600080fd5b6044351515610131576000610151565b60043560443560043560443502041461014957600080fd5b600435604435025b6102e0526102e05134101561016557600080fd5b60c435421061017357600080fd5b7f6033600c60003960336000f33660006000376110006000366000730000000000610320526c010000000000000000000000006000540261033b527f5af4602c57600080fd5b6110006000f30000000000000000000000000000000061034f5260606103206102e051f0806101e757600080fd5b61030052610300513b6101f957600080fd5b61030051301861020857600080fd5b6000600061024461010063aff357496103c052336103e05260243561040052600435610420526044356104405260c43561046052806104805261014080805160200180846103e001828460006004600a8704601201f161026757600080fd5b50508051820160206001820306601f8201039050602001915050806104a0526101c080805160200180846103e001828460006004600a8704601201f16102ac57600080fd5b50508051820160206001820306601f8201039050602001915050806104c05261022080805160200180846103e001828460006004600a8704601201f16102f157600080fd5b50508051820160206001820306601f82010390506020019150506103dc90506000610300515af161032157600080fd5b610300516106c0526024356106e052600435610700526044356107205260c43561074052610100610680526106805161076052610140805160200180610680516106c001828460006004600a8704601201f161037c57600080fd5b5050610660610680516106c00151610240818352015b6102406106605111156103a4576103c5565b600061066051610680516106e00101535b8151600101808352811415610392575b50506020610680516106c0015160206001820306601f82010390506106805101016106805261068051610780526101c0805160200180610680516106c001828460006004600a8704601201f161041a57600080fd5b5050610660610680516106c00151610240818352015b61024061066051111561044257610463565b600061066051610680516106e00101535b8151600101808352811415610430575b50506020610680516106c0015160206001820306601f820103905061068051010161068052610680516107a052610220805160200180610680516106c001828460006004600a8704601201f16104b857600080fd5b5050610660610680516106c00151610240818352015b6102406106605111156104e057610501565b600061066051610680516106e00101535b81516001018083528114156104ce575b50506020610680516106c0015160206001820306601f820103905061068051010161068052337f6e636e2d48c629bff90dcf679b3b3a1ddd639fab3f0c51abca17c3409238aaee610680516106c0a26102e05134101561056057600080fd5b6102e05134036107c05260006000600060006107c051336000f161058357600080fd5b6107c0516107e052337fbb28353e4598c3b9199101a66e0989549b659a59a54d2c27fbb183f1932c8e6d60206107e0a2005b60006000fd5b6100c7610682036100c76000396100c7610682036000f3";

    public static final String FUNC_CREATE_CAMPAIN = "create_campain";

    public static final Event NEWCAMPAIN_EVENT = new Event("NewCampain", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event REFUND_EVENT = new Event("Refund", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected CampainFactory(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CampainFactory(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CampainFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CampainFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<NewCampainEventResponse> getNewCampainEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWCAMPAIN_EVENT, transactionReceipt);
        ArrayList<NewCampainEventResponse> responses = new ArrayList<NewCampainEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewCampainEventResponse typedResponse = new NewCampainEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._issuer = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._address = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._is_free_from_issuer = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._num_coupon = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._wei_per_redeemtion = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse._end_time = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse._name = (String) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse._category = (String) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse._description = (String) eventValues.getNonIndexedValues().get(7).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewCampainEventResponse> newCampainEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewCampainEventResponse>() {
            @Override
            public NewCampainEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWCAMPAIN_EVENT, log);
                NewCampainEventResponse typedResponse = new NewCampainEventResponse();
                typedResponse.log = log;
                typedResponse._issuer = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._address = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._is_free_from_issuer = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._num_coupon = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._wei_per_redeemtion = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse._end_time = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse._name = (String) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse._category = (String) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse._description = (String) eventValues.getNonIndexedValues().get(7).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewCampainEventResponse> newCampainEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWCAMPAIN_EVENT));
        return newCampainEventFlowable(filter);
    }

    public List<RefundEventResponse> getRefundEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REFUND_EVENT, transactionReceipt);
        ArrayList<RefundEventResponse> responses = new ArrayList<RefundEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RefundEventResponse typedResponse = new RefundEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._issuer = (String) eventValues.getIndexedValues().get(0).getValue();
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
                typedResponse._issuer = (String) eventValues.getIndexedValues().get(0).getValue();
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

    public RemoteCall<TransactionReceipt> create_campain(BigInteger _num_coupon, Boolean _is_free_from_issuer, BigInteger _wei_per_redeemtion, String _name, String _category, String _description, BigInteger _end_time, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATE_CAMPAIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_num_coupon), 
                new org.web3j.abi.datatypes.Bool(_is_free_from_issuer), 
                new org.web3j.abi.datatypes.generated.Uint256(_wei_per_redeemtion), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_category), 
                new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.generated.Uint256(_end_time)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    @Deprecated
    public static CampainFactory load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CampainFactory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CampainFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CampainFactory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CampainFactory load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CampainFactory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CampainFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CampainFactory(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CampainFactory> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _campain_template) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_campain_template)));
        return deployRemoteCall(CampainFactory.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CampainFactory> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _campain_template) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_campain_template)));
        return deployRemoteCall(CampainFactory.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CampainFactory> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _campain_template) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_campain_template)));
        return deployRemoteCall(CampainFactory.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CampainFactory> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _campain_template) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_campain_template)));
        return deployRemoteCall(CampainFactory.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class NewCampainEventResponse {
        public Log log;

        public String _issuer;

        public String _address;

        public Boolean _is_free_from_issuer;

        public BigInteger _num_coupon;

        public BigInteger _wei_per_redeemtion;

        public BigInteger _end_time;

        public String _name;

        public String _category;

        public String _description;
    }

    public static class RefundEventResponse {
        public Log log;

        public String _issuer;

        public BigInteger _amount;
    }
}
