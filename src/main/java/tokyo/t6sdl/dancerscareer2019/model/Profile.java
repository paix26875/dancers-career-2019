package tokyo.t6sdl.dancerscareer2019.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class Profile {
	public static final List<String> POSITION_LIST = Arrays.asList("代表", "副代表", "会計", "広報", "渉外・営業", "ジャンルリーダー", "振付師", "公演舞台監督", "公演総合演出", "公演ストーリー制作", "音響制作", "照明制作", "映像制作", "衣装制作", "イベント企画", "新歓企画", "合宿統括", "その他");
	
	private String email;
	private String last_name;
	private String first_name;
	private String kana_last_name;
	private String kana_first_name;
	private String date_of_birth_for_display;
	private LocalDate date_of_birth;
	private String sex;
	private String phone_number;
	private String major;
	private String prefecture;
	private String university;
	private String faculty;
	private String department;
	private String graduation;
	private String academic_degree;
	private List<String> position;
	private List<String> likes;
	
	public void convertForDisplay() {
		StringBuffer graduation = new StringBuffer();
		StringBuffer date_of_birth = new StringBuffer();
		String[] split = this.getGraduation().split("/");
		if (split[1].charAt(0) == '0') {
			split[1] = String.valueOf(split[1].charAt(1));
		}
		this.setGraduation(graduation.append(split[0]).append("年").append(split[1]).append("月").toString());
		this.setDate_of_birth_for_display(date_of_birth.append(this.getDate_of_birth().getYear()).append("年").append(this.getDate_of_birth().getMonthValue()).append("月").append(this.getDate_of_birth().getDayOfMonth()).append("日").toString());
		if (this.getFaculty().equals("-")) {
			this.setFaculty("");
		}
		if (this.getDepartment().equals("-")) {
			this.setDepartment("");
		}
	}
}