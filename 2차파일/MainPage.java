package TenTen;

import java.util.*;

public class MainPage {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String nowID;
        // 1. 초기화 및 시작 단계 + 로그인
        while(true) {
        	System.out.print("OOTDay에 오신 것을 환영합니다!\n로그인하시려면 1을, 회원가입하시려면 2를 입력해주세요: ");
        	String na = s.next();
        	if(na.equals("1"))	break;
        	else {
        		System.out.println("\n=== 회원가입 ===");
                String userID;
                // 아이디 중복 확인 루프
                while(true){
                    System.out.print("사용할 아이디를 입력하세요: ");
                    userID = s.next();
                    if(User.isIDExists(userID)) {
                        System.out.println("이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요.");
                    }else if(userID.length() < 4) {
                        System.out.println("아이디는 4글자 이상이어야 합니다.");
                    }else{
                        System.out.println("사용 가능한 아이디입니다.");
                        break;
                    }
                }
                
                // 비밀번호 입력
                String password;
                while(true) {
                    System.out.print("비밀번호를 입력하세요 (8글자 이상): ");
                    password = s.next();
                    
                    if(password.length() < 8) {
                        System.out.println("비밀번호는 8글자 이상이어야 합니다.");
                    }else{
                        break;
                    }
                }
                
                // 비밀번호 확인
                String confirmPassword;
                while(true) {
                    System.out.print("비밀번호를 다시 입력하세요: ");
                    confirmPassword = s.next();
                    
                    if (password.equals(confirmPassword)) {
                        break;
                    } else {
                        System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                    }
                }
                
                // 닉네임 입력
                System.out.print("닉네임을 입력하세요: ");
                String nickname = s.next();
                
                // 회원가입 처리
                if (User.registerUser(userID, password, nickname)) {
                    System.out.println("회원가입이 완료되었습니다! 환영합니다, " + nickname + "님!");
                    System.out.println("이제 로그인하실 수 있습니다.\n");
                } else {
                    System.out.println("회원가입 중 오류가 발생했습니다. 다시 시도해주세요.");
                }
        		break;
        	}
        }
        
        
        System.out.println("=== OOTDay에 오신 것을 환영합니다! ===");
        User user = new User("CinnaPie1234", "12345678", "은서장"); // 회원가입 되어있다고 상정하고 임의로 설정한 아이디비번입니다! 이대로 입력하셔야 넘어가요!
        
        while(true) {
            System.out.print("로그인해주세요.\nID: ");
            String inputID = s.next();
            System.out.print("PW: ");
            String inputPassword = s.next();
            if(user.login(inputID, inputPassword)) {
                System.out.println("로그인 성공. 환영합니다. " + inputID + "님.");
                nowID = inputID;
                break;
            }
            else {    
                System.out.println("아이디 또는 비밀번호가 일치하지 않습니다. 다시 로그인해주세요.");
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
        ClothingItem top1 = new ClothingItem("topno1", "Top", "White", "Spring", "Cotton");
        ClothingItem bottom1 = new ClothingItem("bottomno1", "Bottom", "Black", "Spring", "Polyester");
        ClothingItem top2 = new ClothingItem("topno2", "Top", "Blue", "Summer", "Linen");
        ClothingItem bottom2 = new ClothingItem("bottomno2", "Bottom", "Beige", "Summer", "Cotton");
        
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
        
        //옷장에 옷 추가
        System.out.print("옷장에 새 옷을 추가하시겠습니까? (y/n): ");
        String yesno = s.next();
        if(yesno.equals("y")) {
        	int clNum=0;
        	ClothingItem cl3;
        	while(true) {
        		System.out.print("등록하려는 옷이 상의면 1, 하의면 2를 입력해주세요: ");
            	clNum = s.nextInt();
            	s.nextLine();
            	if(clNum == 1) {
            		cl3 = new ClothingItem("topno3", "Top");
            		break;
            	}else if(clNum == 2) {
            		cl3 = new ClothingItem("bottomno3", "Bottom");
            		break;
            	}else	System.out.println("잘못된 입력");
        	}
    		System.out.print("등록하려는 옷의 색깔을 영어로 입력해주세요(ex.White): ");
    		String nowColor = s.next();
    		cl3.setColor(nowColor);

    		System.out.print("등록하려는 옷의 착용 계절 영어로 입력해주세요(ex.Spring): ");
    		String nowSeason = s.next();
    		cl3.setSeason(nowSeason);
    		
    		System.out.print("등록하려는 옷의 재질을 영어로 입력해주세요(ex.Cotton): ");
    		String nowMaterial = s.next();
    		cl3.setMaterial(nowMaterial);
    		
    		while(true) {
    			System.out.print("옷에 등록할 태그의 이름을 입력해주세요.(ex.캐주얼) (없다면 0 입력): ");
    			String tagCl3 = s.next();
    			if(tagCl3.equals("0"))	break;
    			else	cl3.editTag(tagCl3);
    		}
    		
    		closet.addItem(cl3);
        }
        
        
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
        boolean feedbackBad=false;
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
                feedbackBad = true;
                break;
            case 5:
                feedbackMessage = "매우 불만족 - 취향에 맞지 않습니다.";
                feedbackBad = true;
                break;
            default:
                feedbackMessage = "피드백을 주셔서 감사합니다.";
        }
        
        if(recommendation != null) {
        	if(feedbackBad == true) {
            	System.out.print("불만족/매우 불만족을 선택하신 이유에 대해서 알려주세요. 참고하여 개선됩니다! : ");
            	String reasonMessage = s.nextLine();
            	feedbackMessage = feedbackMessage.concat("\n이유 : "+reasonMessage);
            }
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
            
            System.out.print("사진을 첨부하시겠습니까?(y/n): ");
            String yesno2 = s.next();
            if(yesno2.equals("y")) {
            	System.out.print("이미지 불러오는 중...\n\n몇 번째 사진을 첨부하시겠습니까?(n 입력): ");
            	int picNum = s.nextInt();
            	s.nextLine();
            	System.out.println(picNum+"번째 사진이 첨부되었습니다!");
            	postContent = postContent.concat("\n(첨부파일 : "+picNum+"번째 사진 이미지)");
            }
            
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
        user.logout(nowID);
        s.close();
    }
}