package sql.warehouseSystem.mvc_mare.model;


public class Adm_ware_table {
    //仓库号
    private int ID;
    //商品号
    private int Goods_id;

    private int Goods_num;


    private String ware_local;

    private int ware_space;

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

    public int getGoods_num() {
        return Goods_num;
    }

    public void setGoods_num(int goods_num) {
        Goods_num = goods_num;
    }

    public String getWare_local() {
        return ware_local;
    }

    public void setWare_local(String ware_local) {
        this.ware_local = ware_local;
    }

    public int getWare_space() {
        return ware_space;
    }

    public void setWare_space(int ware_space) {
        this.ware_space = ware_space;
    }
}
