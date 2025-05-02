package com.springboo.springboot;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private long id;
    private String name;
    private String department;

    public Integer getId() {
        return 0;
    }


    public void setId(int id) {
        this.id = id;
    }
}