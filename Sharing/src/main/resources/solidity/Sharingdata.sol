pragma solidity >0.4.22;
contract Sharingdata{
    
    string  publickeyA;
    
    string c1;//密文
    
    string c2;//对称密钥密文
    
    string KAB;
    
    string c3;
    
    function setPublickey(string  mypkey) public {
        publickeyA = mypkey;
    }
    function getPublickey() public view returns(string){
        return publickeyA;
    }

    function setC1(string  C1) public {
        c1 = C1;
    }
    function getC1() public view returns(string){
        return c1;
    }
    
     function setC2(string  C2) public {
        c2 = C2;
    }
    function getC2() public view returns(string){
        return c2;
    }
    
    function setKAB(string kab) public{
        KAB = kab;
    }
    
    function getKAB() public view returns(string){
        return KAB;
    }
    
    function setC3(string  C3) public {
        c3 = C3;
    }
    function getC3() public view returns(string){
        return c3;
    }
        
}