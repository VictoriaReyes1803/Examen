package com.example.examen;

public class item_view {

        String name;
        String description;
        String edad;
        String phone;

        public item_view(String name, String description,String edad, String phone) {
            this.name = name;
            this.description = description;
            this.edad = edad;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }


        public String getEdad() {
            return edad;
        }

        public void setEdad(String edad) {
            this.edad = edad;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

}
