import logedin from "../Login_signup/Logedin"

function Home() {
    return(
    <>
    <h1> this is Home</h1>
    <span onClick={()=>logedin()} className="btn" > to Loggged in</span>
    </>
    )
}
export default Home