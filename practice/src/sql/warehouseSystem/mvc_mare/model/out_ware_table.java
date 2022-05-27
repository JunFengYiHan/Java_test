package sql.warehouseSystem.mvc_mare.model;


public class out_ware_table {
    //出库单号
    private int out_id;
    //用户ID
    private int user_id;
    //商品名称
    private String Goods_name;
    //厂家
    private String factory;
    //数量
    private int Goods_num;
    //日期
    private String date;
    //提货人
    private String consignee_man;
    //仓库号
    private int ID;
    //商品号
    private int Goods_id;


    public int getOut_id() {
        return out_id;
    }

    public void setOut_id(int out_id) {
        this.out_id = out_id;
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


    public String getConsignee_man() {
        return consignee_man;
    }

    public void setConsignee_man(String consignee_man) {
        this.consignee_man = consignee_man;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getGoods_id() {
        return Goods_id;
    }

    public void setGoods_id(int goods_id) {
        Goods_id = goods_id;
    }
}
