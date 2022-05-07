package dk.via.sep4.models.room;

import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

  private final RoomRepository roomRepository;

  public RoomController(RoomRepository roomRepository)
  {
    this.roomRepository = roomRepository;
  }

  @GetMapping("/room") List<Room> all(){
    return roomRepository.findAll();
  }

  @GetMapping("/room/{id}")
  Room one(@PathVariable java.lang.Long id){
    return roomRepository.findById(id).orElseThrow( () -> new RoomNotFoundException(id));

  }
}
