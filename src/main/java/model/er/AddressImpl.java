package model.er;




public class AddressImpl {

    public Address  Impl(Address address){
                 address
                .setId(1l)
                .setAddress("123");
                 return address;
    }

    public Address address(){
         return this.Impl(null);

    }

}
