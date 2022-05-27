package sql.warehouseSystem.mvc_mare.model;


public class AdmUser {
    //管理员编号
    private int Id;

    //管理员姓名
    private String administrstords_name;

    //密码
    private String administrstords_password;


    public String getAdministrstords_password() {
        return administrstords_password;
    }

    public void setAdministrstords_password(String administrstords_password) {
        this.administrstords_password = administrstords_password;
    }

    public String getAdministrstords_name() {
        return administrstords_name;
    }

    public void setAdministrstords_name(String administrstords_name) {
        this.administrstords_name = administrstords_name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
