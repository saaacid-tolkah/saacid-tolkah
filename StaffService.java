package com.springboo.springboot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffService {
    private final Map<Integer, Staff> staffMap = new HashMap<>();
    private int currentId = 1;

    public List<Staff> getAllStaffs() {
        return new ArrayList<>(staffMap.values());
    }

    public Staff getStaffById(int id) {
        return staffMap.get(id);
    }

    public Staff createStaff(Staff staff) {
        staff.setId(currentId++);
        staffMap.put(staff.getId(), staff);
        return staff;
    }

    public Staff updateStaff(int id, Staff staff) {
        if (!staffMap.containsKey(id)) return null;
        staff.setId(id);
        staffMap.put(id, staff);
        return staff;
    }

    public boolean deleteStaff(int id) {
        return staffMap.remove(id) != null;
    }
}

