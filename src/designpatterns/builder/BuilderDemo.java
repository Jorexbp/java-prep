package designpatterns.builder;

/*
   Builder (Creacional)
   ► Separa la construcción de un objeto complejo de su representación final.
   ► Problema que resuelve: muchos parámetros opcionales / telescoping constructors.
   ► Beneficio: legible, inmutable y con defaults claros.
*/
public class BuilderDemo {

    static class User {
        private final String username;   // obligatorio
        private final String email;      // opcional
        private final String phone;      // opcional
        private final boolean newsletter;// opcional

        private User(Builder b) {
            this.username = b.username;
            this.email = b.email;
            this.phone = b.phone;
            this.newsletter = b.newsletter;
        }
        public static class Builder {
            private final String username;
            private String email;
            private String phone;
            private boolean newsletter;

            public Builder(String username) { this.username = username; }
            public Builder email(String email){ this.email = email; return this; }
            public Builder phone(String phone){ this.phone = phone; return this; }
            public Builder newsletter(boolean val){ this.newsletter = val; return this; }
            public User build() { return new User(this); }
        }
        @Override public String toString() {
            return "User{username='%s', email='%s', phone='%s', newsletter=%s}"
                   .formatted(username, email, phone, newsletter);
        }
    }

    public static void main(String[] args) {
        User u = new User.Builder("jorex").email("jorex@mail.com").newsletter(true).build();
        System.out.println(u);
    }
}
