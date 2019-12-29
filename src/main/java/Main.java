import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import ContractWrapper.Campain;
import ContractWrapper.CampainFactory;
import Roles.Bearer;
import Roles.Distributor;
import Roles.General;
import Roles.Issuer;
import Utils.Utils;
import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableDistinct;
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
        Bearer br = new Bearer("dbbb23642c1a0cc749027d558c6cf2c30d08590bfe471021f924c002c8af5243");
        Distributor dis = new Distributor("6e2211d3e98c4fc33906246c11bc900cb0302e7cec62628f882ca17273dbc1f8");

        // Tạo campain mới
//        iss.createCampain(10,false, 2,"Campain2", "food", "sale off 50% all food at REGR", 2000000000);

        // Lấy danh sách các campain mà issuer đã tạo.
//        for(CampainFactory.NewCampainEventResponse e: iss.getOwnedCampains()){
//            System.out.println("Campain Address: "+e._address);
//            System.out.println("Campain Name: "+e._name);
//            System.out.println("Campain_Description: "+e._description);
//            System.out.println("Campain Num_coupons: " + e._num_coupon);
//            System.out.println("Campain Endtime: "+ e._end_time);
//            System.out.println("--------------------------------");
//        }

//         Lấy danh sách thông tin các distributor tham gia vào một campain.
//        for(Issuer.Distributor dis: iss.getOwnedDistributors("0x80FCB8Eb00AAc5E716E28C8d9C79fb1b5D012230")){
//            System.out.println(dis.address+"  "+dis.num_redeemed+"  "+ dis.num_acquired);
//            System.out.println("-------------------------------");
//        }

        // Thêm distributor.
//        iss.addDistributor("0x57a444709f157DdfFCFDd6efC2117F8bD0BBA478","0xf3A566312478c62e05B1958020B3e837C8E21B42");

        // Xóa distributor.
//        iss.removeDistributor("0xf23a159Fc06FfbedF103BA67905000E18b26B734","0xf3A566312478c62e05B1958020B3e837C8E21B42");

        // Kịch bản khi Bearer quét mã QR để nhận coupon
        // Đầu tiên, giả sử rằng QR đã tồn tại, tức là được distributor tạo ra cho mình bearer có thể sử dụng
        // Bearer quét QR và nhận được đoạn qr_text
//        String qr_text = dis.generateQRForBearer("0x57a444709f157DdfFCFDd6efC2117F8bD0BBA478", "0x855108d766f477f7716636386e4BC2B69c65EFFE");

//        // Ngay khi quét được, bearer gọi tới hàm này để nhận coupon.
//        br.aquire(qr_text);

//         Lấy danh sách các campain mà bearer đã lấy coupon thành công.
        for(General.CampainInfo e: br.getAllAcquiredCampains()){
            System.out.println("Campain Address: "+e.address);
            System.out.println("Campain Name: "+e.name);
            System.out.println("Campain_Description: "+e.description);
            System.out.println("Campain Num_coupons: " + e.total_coupons);
            System.out.println("Campain Num_remain: " + e.num_remain);
            System.out.println("Campain Num_redeemed: " + e.num_redeemed);
            System.out.println("Campain Endtime: "+ e.endtime);
            System.out.println("--------------------------------");
        }


        System.out.println("End!");
    }
}
