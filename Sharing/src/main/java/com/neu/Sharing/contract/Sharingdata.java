package com.neu.Sharing.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.0.
 */
public class Sharingdata extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5061067f806100206000396000f3006080604052600436106100a35763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631b85406781146100a85780631f9276d414610132578063382354a5146101475780634bbc9072146101a257806363697d86146101b757806390427fe01461021057806393fbd690146102695780639f46c235146102c2578063a76f54d2146102d7578063d805d08f146102ec575b600080fd5b3480156100b457600080fd5b506100bd610345565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100f75781810151838201526020016100df565b50505050905090810190601f1680156101245780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561013e57600080fd5b506100bd6103dc565b34801561015357600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101a094369492936024939284019190819084018382808284375094975061043d9650505050505050565b005b3480156101ae57600080fd5b506100bd610454565b3480156101c357600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101a09436949293602493928401919081908401838280828437509497506104b29650505050505050565b34801561021c57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101a09436949293602493928401919081908401838280828437509497506104c59650505050505050565b34801561027557600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101a09436949293602493928401919081908401838280828437509497506104d89650505050505050565b3480156102ce57600080fd5b506100bd6104eb565b3480156102e357600080fd5b506100bd61054c565b3480156102f857600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101a09436949293602493928401919081908401838280828437509497506105ac9650505050505050565b60008054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156103d15780601f106103a6576101008083540402835291602001916103d1565b820191906000526020600020905b8154815290600101906020018083116103b457829003601f168201915b505050505090505b90565b60038054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156103d15780601f106103a6576101008083540402835291602001916103d1565b80516104509060049060208401906105bb565b5050565b60028054604080516020601f60001961010060018716150201909416859004938401819004810282018101909252828152606093909290918301828280156103d15780601f106103a6576101008083540402835291602001916103d1565b80516104509060039060208401906105bb565b80516104509060019060208401906105bb565b80516104509060029060208401906105bb565b60048054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156103d15780601f106103a6576101008083540402835291602001916103d1565b60018054604080516020601f600260001961010087891615020190951694909404938401819004810282018101909252828152606093909290918301828280156103d15780601f106103a6576101008083540402835291602001916103d1565b80516104509060009060208401905b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106105fc57805160ff1916838001178555610629565b82800160010185558215610629579182015b8281111561062957825182559160200191906001019061060e565b50610635929150610639565b5090565b6103d991905b80821115610635576000815560010161063f5600a165627a7a7230582093b1f08d89ed32b36be7be392b89950c1a887adc74a26d6aeb376548838760910029";

    protected Sharingdata(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Sharingdata(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> getPublickey() {
        Function function = new Function("getPublickey", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getKAB() {
        Function function = new Function("getKAB", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setC3(String C3) {
        Function function = new Function(
                "setC3", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(C3)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getC2() {
        Function function = new Function("getC2", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setKAB(String kab) {
        Function function = new Function(
                "setKAB", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(kab)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setC1(String C1) {
        Function function = new Function(
                "setC1", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(C1)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setC2(String C2) {
        Function function = new Function(
                "setC2", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(C2)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getC3() {
        Function function = new Function("getC3", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getC1() {
        Function function = new Function("getC1", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setPublickey(String mypkey) {
        Function function = new Function(
                "setPublickey", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(mypkey)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Sharingdata> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Sharingdata.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Sharingdata> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Sharingdata.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Sharingdata load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sharingdata(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Sharingdata load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Sharingdata(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
