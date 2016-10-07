// I am sorry for using the default package
public class SongRecord {
	private int ranking;
	private String songTitle;
	private String artist;
	private int yearOfRelease;
	public SongRecord (int ranking, String songTitle, String artist, int yearOfRelease)
	{
		this.ranking = ranking;
		this.songTitle = songTitle;
		this.artist = artist;
		this.yearOfRelease = yearOfRelease;
	}
	public int getRanking ()
	{
		return ranking;
	}
	public String getSongtitle ()
	{
		return songTitle;
	}
	public String getArtist ()
	{
		return artist;
	}
	public int getYear ()
	{
		return yearOfRelease;
	}
}
