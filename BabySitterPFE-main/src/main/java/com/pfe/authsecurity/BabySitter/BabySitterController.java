package com.pfe.authsecurity.BabySitter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/api/babysitters")
public class BabySitterController {
    private final BabySitterService babysitterService;

    @Autowired
    public BabySitterController(BabySitterService babysitterService) {
        this.babysitterService = babysitterService;
    }

    // Récupérer tous les babysitters
    @GetMapping
    public List<BabySitter> getAllBabysitters() {
        return babysitterService.getAllBabysitters();
    }

    // Récupérer un babysitter par son ID
    @GetMapping("/{babysitterId}")
    public BabySitter getBabysitterById(@PathVariable Long babysitterId) {
        return babysitterService.getBabySitterById(babysitterId);
    }

    // Créer un nouveau babysitter
    @PostMapping
    public BabySitter createBabysitter(@RequestBody BabySitter babysitter) {
        return babysitterService.createBabysitter(babysitter);
    }

    // Mettre à jour un babysitter existant
    @PutMapping("/{babySitterId}")
    public BabySitter updateBabySitter(@PathVariable Long babySitterId, @RequestBody BabySitter babySitter) {

        return babysitterService.updateBabysitter(babySitterId,babySitter);
    }

    // Supprimer un babysitter
    @DeleteMapping("/{babysitterId}")
    public void deleteBabysitter(@PathVariable Long babysitterId) {
        babysitterService.deleteBabySitter(babysitterId);
    }
}
