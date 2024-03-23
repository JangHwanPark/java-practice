package JavaInheritance;

class Character {
    private String userName;
    private String characterClass;
    private int level = 1, xp = 0;
    private int health, mana, attack, defense;

    public Character(String userName, String characterClass, int health, int mana, int attack, int defense) {
        this.userName = userName;
        this.characterClass = characterClass;
        this.health = health;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
    }

    // userName에 대한 게터와 세터
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // characterClass에 대한 게터
    public String getCharacterClass() {
        return characterClass;
    }

    // health에 대한 게터와 세터
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // mana에 대한 게터와 세터
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    // attack에 대한 게터와 세터
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    // defense에 대한 게터와 세터
    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    // level에 대한 게터
    public int getLevel() {
        return level;
    }

    // xp에 대한 게터
    public int getXp() {
        return xp;
    }

    // 경험치 추가 및 레벨업 처리 메서드
    public void gainXp(int amount) {
        this.xp += amount;
        // 간단한 레벨업 조건 (100XP마다 레벨업)
        while (this.xp >= 100) {
            this.xp -= 100; // 100 XP 감소
            this.level++; // 레벨 증가
            System.out.println(this.userName + " 레벨이 올랐어요! 현재 레벨: " + this.level);
        }
    }
}

public class InheritEx_Character extends Character {
    public InheritEx_Character(String userName,String characterClass, int health, int mana, int attack, int defense) {
        super(userName, characterClass, health, mana, attack, defense);
    }

    public static void main(String[] args) {
        InheritEx_Character warrior = new InheritEx_Character("UserName", "Warrior", 150, 30, 100, 50);

        // 캐릭터 정보 출력
        System.out.println("Character: " + warrior.getUserName());
        System.out.println("Class: " + warrior.getCharacterClass());
        System.out.println("Health: " + warrior.getHealth());
        System.out.println("Mana: " + warrior.getMana());
        System.out.println("Attack: " + warrior.getAttack());
        System.out.println("Defense: " + warrior.getDefense());
    }
}