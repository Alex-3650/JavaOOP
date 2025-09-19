package BuilderPattern;

public class Address {
    private  String name;
    private  String zip;
    private  String address1;
    private  String address2;
    private  String postCode;
    private  String email;
    private  String billingAddress;

    private Address() {

    }
    public static Builder builder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "Address{" +
                "address1='" + address1 + '\'' +
                ", name='" + name + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    public static class Builder{

        private Address address;

        private Builder() {
            this.address =new Address();
        }

        public  Builder setAddress1(String address1) {
                address.address1 = address1;
                return this;
            }

            public Builder setAddress2(String address2) {
                address.address2 = address2;
                return this;
            }

            public Builder setBillingAddress(String billingAddress) {
                address.billingAddress = billingAddress;
                return this;
            }

            public Builder setEmail(String email) {
                address.email = email;
                return this;
            }

            public Builder setName(String name) {
                address.name = name;
                return this;
            }

            public Builder setPostCode(String postCode) {
                address.postCode = postCode;
                return this;
            }

            public Builder setZip(String zip) {
                address.zip = zip;
                return this;
            }

            public Address build(){
            return this.address;
            }
    }


}
