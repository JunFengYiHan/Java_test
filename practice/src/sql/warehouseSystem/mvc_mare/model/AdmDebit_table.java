package sql.warehouseSystem.mvc_mare.model;


public class AdmDebit_table {
   private int debit_id;
   private int user_id;
   private String Goods_name;
   private String factory;
   private int Goods_num;
   private String de_date;
   private String re_date;
   private String debit_man;
   private int ID;
   private int Goods_id;

   public int getDebit_id() {
      return debit_id;
   }

   public void setDebit_id(int debit_id) {
      this.debit_id = debit_id;
   }

   public int getUser_id() {
      return user_id;
   }

   public void setUser_id(int user_id) {
      this.user_id = user_id;
   }

   public String getGoods_name() {
      return Goods_name;
   }

   public void setGoods_name(String goods_name) {
      Goods_name = goods_name;
   }

   public String getFactory() {
      return factory;
   }

   public void setFactory(String factory) {
      this.factory = factory;
   }

   public int getGoods_num() {
      return Goods_num;
   }

   public void setGoods_num(int goods_num) {
      Goods_num = goods_num;
   }

   public String getDe_date() {
      return de_date;
   }

   public void setDe_date(String de_date) {
      this.de_date = de_date;
   }

   public String getRe_date() {
      return re_date;
   }

   public void setRe_date(String re_date) {
      this.re_date = re_date;
   }

   public String getDebit_man() {
      return debit_man;
   }

   public void setDebit_man(String debit_man) {
      this.debit_man = debit_man;
   }

   public int getID() {
      return ID;
   }

   public void setID(int ID) {
      this.ID = ID;
   }

   public int getGoods_id() {
      return Goods_id;
   }

   public void setGoods_id(int goods_id) {
      Goods_id = goods_id;
   }
}
