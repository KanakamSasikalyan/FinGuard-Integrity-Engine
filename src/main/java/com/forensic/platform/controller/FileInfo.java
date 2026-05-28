
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/fileinfo")
public class FileInfo{
	
	@GetMapping("/getinfo")
	public String getFileInfo(@RequestParam String filePath){
		return filePath;
	}
	
}