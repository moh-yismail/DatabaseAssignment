package org.example.domain;

public class Offices {
        private Integer officeCode;
        private String city;
        private String phone;
        private String addressLine1;
        private String addressLine2;
        private String state;
        private String country;
        private String postalCode;
        private String territory;

        public Offices(
                Integer officeCode,
                String city,
                String phone,
                String addressLine1,
                String addressLine2,
                String state,
                String country,
                String postalCode,
                String territory) {
            this.officeCode = officeCode;
            this.city = city;
            this.phone = phone;
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.state = state;
            this.country = country;
            this.postalCode = postalCode;
            this.territory = territory;
        }

        public Integer getOfficeCode() {
            return officeCode;
        }
        public String getCity() {
            return city;
        }
        public String getPhone() { return phone; }
        public String getAddressLine1() { return addressLine1; }
        public String getAddressLine2() { return addressLine2; }
        public String getState() { return state; }
        public String getCountry() { return country; }
        public String getPostalCode() { return postalCode; }
        public String getTerritory() { return territory; }


        @Override
        public String toString() {
            return city + " phone: " + phone + " country: " + country;
        }
    }
