package Roles;

import ContractWrapper.Campain;
import ContractWrapper.CampainFactory;
import io.reactivex.Flowable;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthLog;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.util.List;

public class Issuer extends General {
    public Issuer(String _private_key){
        super(_private_key);
    }

    /** Tạo campain mới.
     @param number_of_coupons: Số lượng coupons phát động trong chiến dịch.
     @param is_free_from_issuer: true thì bearer có thể lấy  miễn phí coupon từ issuer (đây là những coupons mà bearer có thể nhìn thấy trong app, ko cần quét QR để lấy.
     @param wei_per_redeemtion: Số wei (tiền) mà mỗi distributor nhận được khi giới thiệu.
     @param campain_name: tên chiến dịch.
     @param category: tên category.
     @param description: description
     @param time_limit: thời gian tồn tại của coupons. Cái này cho user chọn ngày tháng giờ, ô tính delta vs hiện tại để quy ra giây rồi pass vào
     */
    public void createCampain(long number_of_coupons, boolean is_free_from_issuer, long wei_per_redeemtion, String campain_name,
                              String category, String description, long time_limit) throws Exception {
        TransactionReceipt txn_recv = this.factory.create_campain(BigInteger.valueOf(number_of_coupons), is_free_from_issuer, BigInteger.valueOf(wei_per_redeemtion),
                campain_name, category, description, BigInteger.valueOf(time_limit), BigInteger.valueOf(number_of_coupons*wei_per_redeemtion)).sendAsync().get();
        if(txn_recv.getBlockHash().isEmpty()) {
            throw new Exception();
        }
    }

    public List<EthLog.LogResult> createFilterForEvent() throws Exception {
        EthFilter ethFilter =
                new EthFilter(
                        DefaultBlockParameterName.EARLIEST,
                        DefaultBlockParameterName.LATEST,
                        this.factory_address);
        EthLog ethLog = web3j.ethGetLogs(ethFilter).send();
        return ethLog.getLogs();
    }


}