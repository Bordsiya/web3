import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ManagedBean(name = "clockBean")
@RequestScoped
public class ClockBean implements Serializable {
    private LocalDateTime currentTime = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public LocalDateTime getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public void update(){
        this.currentTime = LocalDateTime.now();
    }

    public String getFormattedCurrentTime(){
        return this.formatter.format(this.currentTime);
    }
}
