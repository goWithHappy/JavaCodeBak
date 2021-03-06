package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象构建
 * @author Admain
 *
 */
public interface AbstractFile {
	void killVirus();
}
class ImageFile implements AbstractFile{
	private String name;
	public ImageFile(String name) {
		this.name=name;
	}

	@Override
	public void killVirus() {
		System.out.println("----查杀图像文件"+name+",进行查杀:");
	}
	
}
class TextFile implements AbstractFile{
	private String name;
	public TextFile(String name) {
		this.name=name;
	}
	@Override
	public void killVirus() {
		System.out.println("---正在查杀"+name+",文本文件..");
	}
	
}
class VideoFile implements AbstractFile{
	private String name;
	public VideoFile(String name) {
		this.name=name;
	}
	@Override
	public void killVirus() {
		System.out.println("--正在查杀"+name+"影像文件..");
	}
}
class Folder implements AbstractFile{
	private String name;
	public Folder(String name) {
		this.name=name;
	}
	private List<AbstractFile> list=new ArrayList<>();
	public void add(AbstractFile file){
		list.add(file);
	}
	public void remove(AbstractFile file){
		list.remove(file);
	}
	public AbstractFile getChild(int index){
		return list.get(index);
	}
	@Override
	public void killVirus() {
		System.out.println("--正在查杀"+name+",文件夹..");
		for (AbstractFile file : list) {
			file.killVirus();   //会自动调用自己的KillVirus方法
		}
	}
	
}