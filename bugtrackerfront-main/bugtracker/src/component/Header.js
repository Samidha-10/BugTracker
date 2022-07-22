import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';

function Header() {
  return (
    <Navbar bg="dark" variant="dark">
      <Container>
        <Navbar.Brand href="#home">BUG Tracker</Navbar.Brand>
      </Container>
    </Navbar>
  );
}
export default Header;