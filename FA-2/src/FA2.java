import java.time.Duration;
import java.util.AbstractCollection;
import java.util.ArrayList;

class MusicTrack{
    //this class defines music track objects
    String name;
    double duration;
    MusicTrack(String name,double duration){
        this.name = name;
        this.duration = duration;
    }
    MusicTrack(String name){
        //this constructor is used when we only know the name of the song
        this.name = name;
    }
}
abstract class Performance{

    private MusicTrack[] trackList;

    public void setTrackList(MusicTrack[] trackList) {
        this.trackList = trackList;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    private int year;
    public int getYear(){
        return year;
    }

    private String venue;
    public String getVenue() {
        return venue;
    }



    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }




    public abstract void record();
    //since both live & studio performances should have record method with different implementation

    public mainArtist getMain_Artist() {
        return main_Artist;
    }

    public void setMain_Artist(mainArtist main_Artist) {
        this.main_Artist = main_Artist;
    }

    private mainArtist main_Artist;


    public backupSinger[] getBackup_singers() {
        return backup_singers;
    }

    public void setBackup_singers(backupSinger[] backup_singers) {
        this.backup_singers = backup_singers;
    }

    private backupSinger[] backup_singers;

    public BackupDancer[] getBackup_dancers() {
        return backup_dancers;
    }

    public void setBackup_dancers(BackupDancer[] backup_dancers) {
        this.backup_dancers = backup_dancers;
    }

    private BackupDancer[] backup_dancers;

}

class LivePerformance extends Performance{
    LivePerformance(String performanceName,String mainArtistName){
        this.setMain_Artist(new mainArtist(mainArtistName)); // initialises a main artist object
        this.setName(performanceName);
        System.out.println("Welcome to the Performance "+ this.getName() +" by "+this.getMain_Artist().getName());
    }
    public void record(){
        System.out.println("This is the method "+ "record"+" in the class " + "LivePerformance");
    }
    public void audienceInteraction(){
        //main artist can interfere with the audience only in a live performance
        this.getMain_Artist().audienceInterference();
        System.out.println("This is the method "+ "audienceInteraction"+" in the class " + "LivePerformance");
    }
    /*LivePerformance(){
        System.out.println("Welcome to the Performance "+ this.getName() +" by "+this.getMain_Artist().getName());

    }*/

}
class StudioPerformance extends Performance{
    public void record(){
        System.out.println("This is the method "+ "record"+" in the class "+"StudioPerformance");
    }
    public void audioProcessing(){
        System.out.println("This is the method "+ "audioProcessing"+" in the class "+"StudioPerformance");
    }

}
interface IBackup{
    public void backup();
}

class Artist{
    public String getName() {
        return name;
    }public void setName(String name) {
        this.name = name;
    }private String name;

}
class Singer extends Artist{
    public void sing(){
        System.out.println("This is the method "+ "sing"+" in the class Singer");
    }
}

class mainArtist extends Singer{
    public mainArtist(String artistName) {
        this.setName(artistName);
    }

    public void audienceInterference(){
        System.out.println("This is the method "+ "audienceInterference"+" in the class "+"mainArtist");
    }
    public void sing(){
        System.out.println("This is the method "+ "sing"+" in the class "+"mainArtist");
        this.sing();
    }
}

class backupSinger extends Singer implements IBackup{
    @Override
    public void backup() {
        //backup singers can only backup by singing
        System.out.println("This is the method "+ "backup"+" in the class backupSinger");
        this.sing();
    }
    backupSinger(String name){
        this.setName(name);
    }
}
class BackupDancer extends Artist implements IBackup{
    @Override
    public void backup() {
        System.out.println("This is the method "+ "backupDancer"+" in the class backupDancer");
    }
    BackupDancer(String name){
        this.setName(name);
    }
}



public class FA2 {



    public static void main(String[] args) {
        // For the specified performance that was mentioned in the Question

        String performanceName = "Eras Tour";
        String mainArtist = "Taylor Swift";
        int year =2023;
        String venue = "Glendale";
        BackupDancer[] backup_Dancers = {new BackupDancer("Stephanie"),new BackupDancer("Jake")};
        backupSinger[] backup_Singers = {new backupSinger("Jeslyn"),new backupSinger("Melanie")};
        MusicTrack[] tracklist = new MusicTrack[]{ new MusicTrack("Lavender Haze"),
                new MusicTrack(" All Too Well"),
                new MusicTrack("the lakes"),
                new MusicTrack("The Man"),
                new MusicTrack("Love Story")};

        LivePerformance p1 = new LivePerformance(performanceName,mainArtist);

        p1.setTrackList(tracklist);
        p1.setYear(year);
        p1.setVenue(venue);
        p1.setBackup_singers(backup_Singers);
        p1.setBackup_dancers(backup_Dancers);
    }
}
