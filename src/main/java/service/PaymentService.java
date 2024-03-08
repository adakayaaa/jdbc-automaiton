package service;

import mappers.PaymentMapper;
import model.Payment;
import utils.DBUtils;

import java.util.List;


public class PaymentService {
    public List<Payment> getAllPayments(){
        String query="SELECT * FROM payment;";
        return DBUtils.executeQuery(query,new PaymentMapper());
    }

    public Payment getAPaymentByPaymentId(int paymentId){
        String query="SELECT * FROM payment WHERE payment_id='"+paymentId+"'";
        List<Payment> listOfPayments= DBUtils.executeQuery(query,new PaymentMapper());
        return listOfPayments.isEmpty()? null: listOfPayments.get(0);
    }
}
