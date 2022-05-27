package sql.warehouseSystem.mvc_mare.model;


public class Adm_input_ware {
    private int input_id;
    private int user_id;
    private String Goods_name;
    private String factory;
    private int Goods_num;
    private String data;
    private String Delivery_man;
    private int ID;
    //private int Goods_id;
    public int getInput_id() {
        return input_id;
    }

    public void setInput_id(int input_id) {
        this.input_id = input_id;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDelivery_man() {
        return Delivery_man;
    }

    public void setDelivery_man(String delivery_man) {
        Delivery_man = delivery_man;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

//    public int getGoods_id() {
//        return Goods_id;
//    }
//
//    public void setGoods_id(int goods_id) {
//        Goods_id = goods_id;
//    }
}
