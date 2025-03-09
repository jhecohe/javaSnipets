class ExThread {

    public static final int MAX_PASSWORD = 9999;

    private static abstract class HackerThread extends Thread {

        protected Vault vault;
        public HackerThread( Vault vault ){
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("Starting thread " + this.getName());
            super.start();
    }
    private static class Vault {

        private int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean isValidPassword(int pass) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
            return pass == this.password;
        }
    }
}
