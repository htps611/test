package com.shoesworld.controllers;

import com.shoesworld.models.AdminEntity;
import com.shoesworld.models.AdminLogEntity;
import com.shoesworld.services.AdminLogService;
import com.shoesworld.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminLogService adminLogService;

    @RequestMapping(value = "/admins", method = RequestMethod.GET)
    public ResponseEntity<List<AdminEntity>> getAllAdmin() {
        List<AdminEntity> adminList = adminService.getAllAdmin();
        if (adminList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<AdminEntity>>(adminList, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAdminById(@PathVariable("id") int id) {
        AdminEntity admin = adminService.getAdminById(id);
        if (admin == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AdminEntity>(admin, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/", method = RequestMethod.POST)
    public ResponseEntity<?> createAdmin(@RequestBody AdminEntity adminEntity, UriComponentsBuilder ucBuilder) {
        if (adminService.isExist(adminEntity.getName())) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        adminService.save(adminEntity);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ucBuilder.path("/admin/{id}").buildAndExpand(adminEntity.getId()).toUri());
        return new ResponseEntity<String>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAdmin(@PathVariable("id") int id, @RequestBody AdminEntity adminEntity) {
        AdminEntity currentAdminEntity = adminService.getAdminById(id);
        if (currentAdminEntity == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        currentAdminEntity.setRoleId(adminEntity.getRoleId());
        currentAdminEntity.setName(adminEntity.getName());
        currentAdminEntity.setEmail(adminEntity.getEmail());
        currentAdminEntity.setPassword(adminEntity.getPassword());
        currentAdminEntity.setIsActive(adminEntity.getIsActive());
        adminService.update(currentAdminEntity);
        return new ResponseEntity<AdminEntity>(currentAdminEntity, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAdmin(@PathVariable("id") int id) {
        AdminEntity adminEntity = adminService.getAdminById(id);
        if (adminEntity == null) {
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
        adminService.delete(adminEntity);
        return new ResponseEntity<AdminEntity>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/admin/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAllAdmins() {
        adminService.deleteAll();
        return new ResponseEntity<AdminEntity>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/admin/{id}/log", method = RequestMethod.GET)
    public ResponseEntity<List<AdminLogEntity>> getLog(@PathVariable("id") int id) {
        List<AdminLogEntity> logList =  adminLogService.getAdminLogByAdminId(id);
        if (logList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<AdminLogEntity>>(logList, HttpStatus.OK);
    }
}
