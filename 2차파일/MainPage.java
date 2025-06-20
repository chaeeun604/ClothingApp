package TenTen;

import java.util.*;

public class MainPage {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // 1. 초기화 및 시작 단계 + 로그인
        System.out.println("=== TenTen 스타일 추천 시스템에 오신 것을 환영합니다! ===");
        User user = new User("CinnaPie1234", "12345678", "은서장"); // 회원가입 되어있다고 상정하고 임의로 설정한 아이디비번입니다! 이대로 입력하셔야 넘어가요!
        
        while(true) {
            System.out.print("로그인하세요.\nID: ");
            String inputID = s.next();
            System.out.print("PW: ");
            String inputPassword = s.next();
            if(user.login(inputID, inputPassword)) {
                System.out.println("로그인 성공. 환영합니다. " + inputID + "님.");
                break;
            }
            else {    
                System.out.println("다시 로그인하세요.");
            }
        }
        
        // 2. 사용자 프로필 및 데이터 설정
        System.out.println("\n=== 사용자 프로필 및 데이터 설정 ===");
        System.out.println("사용자의 키와 몸무게, 발사이즈를 입력받습니다.");
        System.out.print("현재 키 입력(cm): ");
        double height = s.nextDouble();
        System.out.print("현재 몸무게 입력(kg): ");
        double weight = s.nextDouble();
        System.out.print("현재 발사이즈 입력: ");
        int footSize = s.nextInt();
        user.updateProfile(height, weight, footSize);
        
        // 옷장 초기 데이터 설정
        System.out.println("\n저장된 옷장을 불러옵니다.");
        Closet closet = user.getMyCloset();
        
        // 샘플 의류 아이템 추가 (예시일 뿐입니다! 옷 추가 기능은 여기엔 아직 없어요..)
        ClothingItem top1 = new ClothingItem("top01", "Top", "White", "Spring", "Cotton");
        ClothingItem bottom1 = new ClothingItem("bottom01", "Bottom", "Black", "Spring", "Polyester");
        ClothingItem top2 = new ClothingItem("top02", "Top", "Blue", "Summer", "Linen");
        ClothingItem bottom2 = new ClothingItem("bottom02", "Bottom", "Beige", "Summer", "Cotton");
        
        // 나중에 태그 검색할 때 쓸 거!
        top1.editTag("캐주얼");
        top1.editTag("데일리");
        bottom1.editTag("포멀");
        top2.editTag("시원한");
        bottom2.editTag("편안한");
        
        closet.addItem(top1);
        closet.addItem(bottom1);
        closet.addItem(top2);
        closet.addItem(bottom2);
        
        System.out.println("옷장에 총 " + closet.getAllItems().size() + "개의 아이템이 있습니다.");
        
        
        // 3. 데이터 수집 및 분석 단계
        System.out.println("\n=== 데이터 수집 및 분석 ===");
        
        // 오늘 날씨 정보 가져오기
        System.out.println("오늘의 날씨를 불러옵니다..."); //Date 클래스는 일단 두기만 하고 사용하지 않았습니다!
        Weather todayWeather = Weather.getTodayWeather();
        System.out.println("날씨: " + todayWeather.getCondition() + 
                         ", 평균기온: " + todayWeather.getAverageTemp() + "°C");
        
        // 오늘 일정 설정
        System.out.println("오늘의 일정을 설정합니다.");
        Date today = new Date();
        Schedule todaySchedule = new Schedule(today, "09:00", "출근", "중요한 회의 있음");
        user.addSchedule(todaySchedule);
        System.out.println("일정: " + todaySchedule.getTitle() + " (" + todaySchedule.getTime() + ")");
        System.out.println("메모: " + todaySchedule.getMemo());
        
        // 4. AI 추천 엔진 활용해 오늘의 의상 추천
        System.out.println("\n=== AI 의상 추천 시스템 ===");
        AIEngine aiEngine = new AIEngine();
        
        // 사용자 스타일 학습을 위한 선호 스타일 설정
        List<Style> likedStyles = new ArrayList<>();
        Style casualStyle = new Style("casual001", "캐주얼");
        Style formalStyle = new Style("formal001", "포멀");
        casualStyle.likeStyle();
        casualStyle.likeStyle(); // 평점 2.0
        formalStyle.likeStyle(); // 평점 1.0
        likedStyles.add(casualStyle);
        likedStyles.add(formalStyle);
        
        System.out.println("사용자 스타일 선호도를 학습합니다...");
        aiEngine.learnUserStyle(user, likedStyles);
        
        // AI 추천 코디 생성
        System.out.println("AI가 오늘의 코디를 추천합니다...");
        Recommendation recommendation = aiEngine.generateRecommendation(user, todayWeather, todaySchedule);
        
        if (recommendation != null) {
            Outfit outfit = recommendation.generateOutfit(user, todayWeather, todaySchedule);
            if (outfit != null) {
                System.out.println("\n [ 오늘의 추천 코디 ]");
                System.out.println("추천 이유: " + recommendation.getRecommendationReason());
                outfit.showOutfit();
                System.out.println("스타일 설명: " + outfit.getStyleExplanation());
            } else {
                System.out.println("죄송합니다. " + recommendation.getRecommendationReason());
            }
        }
        
        // 5. 사용자 상호작용 (피드백 수집, 학습)
        System.out.println("\n=== 사용자 피드백 수집 ===");
        System.out.print("추천받은 코디가 만족스러우신가요? (1: 매우 만족, 2: 만족, 3: 보통, 4: 불만족, 5: 매우 불만족): ");
        int satisfaction = s.nextInt();
        s.nextLine(); // 버퍼 클리어 (엔터용)
        
        String feedbackMessage = "";
        switch(satisfaction) {
            case 1:
                feedbackMessage = "매우 만족 - 완벽한 추천이었습니다!";
                break;
            case 2:
                feedbackMessage = "만족 - 좋은 추천이었습니다.";
                break;
            case 3:
                feedbackMessage = "보통 - 괜찮은 추천이었습니다.";
                break;
            case 4:
                feedbackMessage = "불만족 - 개선이 필요합니다.";
                break;
            case 5:
                feedbackMessage = "매우 불만족 - 취향에 맞지 않습니다.";
                break;
            default:
                feedbackMessage = "피드백을 주셔서 감사합니다.";
        }
        
        if (recommendation != null) {
            recommendation.addFeedback(user, feedbackMessage);
            System.out.println("피드백이 등록되었습니다: " + feedbackMessage);
        }
        
        // 6. 커뮤니티 기능 연동
        System.out.println("\n=== 커뮤니티 기능 ===");
        System.out.print("오늘의 코디를 커뮤니티에 공유하시겠습니까? (y/n): ");
        String shareChoice = s.nextLine();
        
        if (shareChoice.equalsIgnoreCase("y")) {
            System.out.print("게시글 내용을 입력하세요: ");
            String postContent = s.nextLine();
            
            CommunityPost post = new CommunityPost("post001", user, "오늘의 코디: " + postContent);
            post.showPost();
            
            /*
            // 샘플 댓글 추가
            User commenter = new User("friend123", "password", "친구");
            Comment comment = new Comment("comment001", commenter, "정말멋져요대박");
            post.addComment(comment);
            comment.showComment();
            */
            
            System.out.println("커뮤니티에 성공적으로 공유되었습니다!");
        }
        
        // 7. 쇼핑 연동 및 추천
        System.out.println("\n=== 쇼핑 추천 ===");
        System.out.println("현재 계절과 스타일에 맞는 추천 상품을 확인해보세요!");
        
        // 이거 그냥 예시로 올려둔거라 실제로는 API나 외부 링크에서 가져오는 걸로 생각하시면 되겠습니다!
        List<ShoppingItem> recommendedItems = new ArrayList<>();
        ShoppingItem jacket = new ShoppingItem("봄 자켓", "http://gmarket.com/jacket", 89000, "아우터");
        ShoppingItem shoes = new ShoppingItem("캐주얼 스니커즈", "http://coupang.com/shoes", 65000, "신발");
        recommendedItems.add(jacket);
        recommendedItems.add(shoes);
        
        for (ShoppingItem item : recommendedItems) {
            item.displayItemInfo();
        }
        
        // 8. 시스템 설정 및 개인화
        System.out.println("\n=== 시스템 설정 ===");
        Settings settings = new Settings();
        settings.showSettings();
        
        while(true) {
            System.out.print("알림 설정을 변경하시겠습니까? (y/n): ");
            String notificationChoice = s.nextLine();
            if(notificationChoice.equalsIgnoreCase("y")) {
                settings.toggleNotifications();
                break;
            }else if(notificationChoice.equalsIgnoreCase("n")){
            	System.out.println("알림설정을 변경하지 않았습니다.");
            	break;
            }else	System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
        
        while(true) {
            System.out.print("다크모드를 변경하시겠습니까? (y/n): ");
            String darkModeChoice = s.nextLine();
            if(darkModeChoice.equalsIgnoreCase("y")) {
                settings.toggleDarkMode();
                break;
            }
            else if(darkModeChoice.equalsIgnoreCase("n")) {
            	System.out.println("다크모드로 변경하지 않았습니다.");
                break;
            }else {
            	System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
        
        System.out.println("변경된 설정:");
        settings.showSettings();
        
        // 9. 옷장 관리 기능
        while(true) {
        	System.out.println("\n=== 옷장 관리 ===");
            System.out.print("옷장을 관리하시겠습니까? (1: 아이템 검색, 2: 카테고리별 보기, 3: 태그로 검색, 0: 건너뛰기): ");
            int closetChoice = s.nextInt();
            s.nextLine(); // 버퍼 클리어
            
            switch(closetChoice) {
                case 1:
                    System.out.print("검색할 태그를 입력하세요: ");
                    String searchTag = s.nextLine();
                    List<ClothingItem> taggedItems = closet.findItemByTag(searchTag);
                    System.out.println("'" + searchTag + "' 태그가 있는 아이템: " + taggedItems.size() + "개");
                    break;
                    
                case 2:
                    System.out.print("카테고리를 입력하세요 (Top/Bottom): ");
                    String category = s.nextLine();
                    List<ClothingItem> categoryItems = closet.getItemsByCategory(category);
                    System.out.println(category + " 카테고리 아이템: " + categoryItems.size() + "개");
                    break;
                    
                case 3:
                    System.out.print("검색할 태그를 입력하세요: ");
                    String tag = s.nextLine();
                    List<ClothingItem> foundItems = closet.findItemByTag(tag);
                    System.out.println("검색 결과: " + foundItems.size() + "개의 아이템을 찾았습니다.");
                    break;
                    
                default:
                    System.out.println("옷장 관리를 건너뜁니다.");
            }
            System.out.print("로그아웃 하시겠습니까? (y/n) : ");
            String a = s.next();
            if(a.equals("y"))	break;
            else	continue;
            
        }
        
        
        // 10. 전체 실행 흐름 마무리
        System.out.println("\n=== 오늘의 활동 요약 ===");
        System.out.println("- 프로필 업데이트 완료");
        System.out.println("- AI 코디 추천 받음");
        System.out.println("- 사용자 피드백 제공");
        if (shareChoice.equalsIgnoreCase("y")) {
            System.out.println("- 커뮤니티 공유 완료");
        }
        System.out.println("- 쇼핑 아이템 확인");
        System.out.println("- 시스템 설정 조정");
        
        System.out.println("\n감사합니다! 좋은 하루 되세요!");
        
        // 로그아웃
        user.logout();
        s.close();
    }
}

/*
package TenTen;

import java.util.Scanner;

public class MainPage {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// 1. 초기화 및 시작 단계
		User user = new User("CinnaPie1234", "12345678", "은서장");
		/*
		while(true) {
			System.out.print("로그인하세요.\nID:");
			String inputID = s.next();
			System.out.print("PW:");
			String inputPassword = s.next();
			if(user.login(inputID, inputPassword)) {
				System.out.println("로그인 성공. 환영합니다. "+inputID+"님.");
				break;
			}
			else	System.out.println("다시 로그인하세요.");
		}
		
		// 2. 사용자 프로필 및 데이터 설정
		System.out.println("사용자 프로필 및 데이터를 설정합니다.");
		System.out.println("사용자의 키와 몸무게, 발사이즈를 입력받습니다.");
		System.out.print("현재 키 입력: ");
		double height = s.nextDouble();
		System.out.print("현재 몸무게 입력: ");
		double weight = s.nextDouble();
		System.out.print("현재 발사이즈 입력: ");
		int footSize = s.nextInt();
		user.updateProfile(height, weight, footSize);
		
		System.out.println("저장된 옷장을 불러옵니다.");
		Closet closet = new Closet();
        ClothingItem top = new ClothingItem("top01", "Top", "White", "Spring", "Cotton");
        ClothingItem bottom = new ClothingItem("bottom01", "Bottom", "Black", "Spring", "Polyester");
        closet.addItem(top);
        closet.addItem(bottom);
        System.out.println(closet.getAllItems()); //이거 출력 해겷해야함
		
		
        // 3. 데이터 수집 및 분석 단계
		System.out.println("날씨를 불러옵니다.");
		Weather weather = new Weather(date, 22.0, 16.0, "Sunny", 0.0); //date 수정 필요
		System.out.println(weather);

		System.out.println("일정을 불러옵니다.");
		Schedule schedule = new Schedule(date, "09:00", "출근", "회의 있음"); //date 수정 필요
		System.out.println(schedule);
		
		// 4. AI 추천 엔진 활용해 오늘의 의상 추천

		AIEngine aiEngine = new AIEngine();
        Recommendation recommendation = aiEngine.generateRecommendation(user, weather, schedule);
        
        if (recommendation != null && recommendation.generateOutfit(user, weather, schedule) != null) {
            System.out.println("추천 이유: " + recommendation.getRecommendationReason());
            Outfit outfit = recommendation.generateOutfit(user, weather, schedule);
            System.out.println("추천 코디: " + outfit.getStyleExplanation());
        }else	System.out.println(recommendation.getRecommendationReason());
        
        // 5. 사용자 상호작용 (피드백 수집, 학습)
        List<Style> likedStyles = new ArrayList<>();
        Style casualStyle = new Style("casual001", "캐주얼", 4.5);
        likedStyles.add(casualStyle);
        aiEngine.learnUserStyle(user, likedStyles);
        
        
	}

}
*/