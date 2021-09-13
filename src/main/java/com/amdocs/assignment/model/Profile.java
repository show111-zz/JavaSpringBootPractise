package com.amdocs.assignment.model;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String address;

    private String phone;

    @OneToOne(cascade = CascadeType.PERSIST, optional = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /**
     * Get the id from the profile
     * @return the id from profile
     */
    public long getId() {
        return id;
    }

    /**
     * Set id value to the profile object
     * @param id id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get address from profile
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address value to profile
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the phone value to profile
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone to profile
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the user to profile
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user to profile
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * ToString method for the profile object
     * @return
     */
    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", user=" + user +
                '}';
    }
}
