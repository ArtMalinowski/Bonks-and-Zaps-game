
public interface Ibeings {
	public String getName();

	public Position getPosition();

	public void setPosition(Position position);

	public void actMove(Beings changePositionBeing, boolean ifBonk);
}
