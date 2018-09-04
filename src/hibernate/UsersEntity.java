package hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "myweb2", catalog = "")
public class UsersEntity {
    private int uid;
    private String username;
    private String password;

    public UsersEntity() {
    }

    public UsersEntity(int uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    @Id
    @Column(name = "UID")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return uid == that.uid &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, username, password);
    }
}
