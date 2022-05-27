package sql.warehouseSystem.mvc_mare.model;


public class Goods_table {
    //商品名称
    private String Goods_name;
    //商品号
    private int Goods_id;
    //厂家
    private String factory;
    //数量
    private int Goods_num;
    //生产日期
    private String Goods_date;
    //仓库号
    private int ID;

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

    public String getGoods_date() {
        return Goods_date;
    }

    public void setGoods_date(String goods_date) {
        Goods_date = goods_date;
    }

    public int getGoods_id() {
        return Goods_id;
    }

    public void setGoods_id(int goods_id) {
        Goods_id = goods_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
