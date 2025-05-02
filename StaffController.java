package com.springboo.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {





        private final StaffService staffService;

        public StaffController(StaffService staffService) {
            this.staffService = staffService;
        }

        @GetMapping
        public List<Staff> getAll() {
            return staffService.getAllStaffs();
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getById(@PathVariable int id) {
            Staff staff = staffService.getStaffById(id);
            return staff != null ? ResponseEntity.ok(staff) :
                    ResponseEntity.status(404).body("Staff not found");
        }

        @PostMapping
        public ResponseEntity<Staff> create(@RequestBody Staff staff) {
            return ResponseEntity.status(201).body(staffService.createStaff(staff));
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> update(@PathVariable int id, @RequestBody Staff staff) {
            Staff updated = staffService.updateStaff(id, staff);
            return updated != null ? ResponseEntity.ok(updated) :
                    ResponseEntity.status(404).body("Staff not found");
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> delete(@PathVariable int id) {
            return staffService.deleteStaff(id) ?
                    ResponseEntity.ok("Deleted") :
                    ResponseEntity.status(404).body("Staff not found");
        }
    }


