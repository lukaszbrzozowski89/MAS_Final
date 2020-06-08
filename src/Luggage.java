import enums.LuggageType;

public class Luggage extends ObjectPlusPlus {

    private int id;
    private LuggageType luggageType;

    public Luggage(int id, LuggageType luggageType) {
        this.id = id;
        this.luggageType = luggageType;
    }

    public int getId() {
        return id;
    }

    public LuggageType getLuggageType() {
        return luggageType;
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "id=" + id +
                ", luggageType=" + luggageType +
                '}';
    }
}
