import { useEffect, useState } from 'react'
import axios from 'axios';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css'
import Redirector from './Redirector';

function App() {
  const [urls, setUrls] = useState([]);
  const [urlObj, setUrlObj] = useState(null);
  const [originalUrl, setOriginalUrl] = useState("");
  const [shortID, setShortID] = useState("");
  const [qrUrl, setQrUrl] = useState("");

  const clickHandler = async () => {
    try {
      const response = await fetch("http://localhost:8080/url", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: originalUrl
      });
      if (!response.ok) {
        throw new Error("Bogus URL.");
      }
      const data = await response.json();
      console.log("Data is ", data);
      let qrString = "https://api.qrserver.com/v1/create-qr-code/?data=http://localhost:5173/";
      qrString += data.shortId;
      qrString += "&amp;size=150x150";
      setQrUrl(qrString);
      console.log("QR URL is ", qrString);
      document.getElementById("shortURL").innerHTML="http://localhost:5173/"+data.shortId;
      document.getElementById("shortURL").href="http://localhost:5173/"+data.shortId;
      document.getElementById("qrCode").src=qrString;
    } catch (error) {
      console.error("Error shortening URL", error);
      alert("Please enter a valid URL.");
    }
  }

  return (
    <Router>
    <div className="App">
      <div className="main-wrapper mainWrapper_eExm">
        <div className="rcss flex column">
          <div className="overlay-bg-container">
            <div className="image"></div>
            <div className="content rcss flex column centerSelf">
              <div className="welcome-content rcss p-16 borderRadius-16 flex colWithGap-16">
                <h1>Wells Genuine URL Diminisher</h1>
                <h3><em>"Just like TinyURL, but not as good"</em></h3>
                <p>&nbsp;</p>
                <Routes>
                  <Route 
                    path="/"
                     element={
                       <div>
                        <input id="urlInput" type="text" className="entryfield" placeholder="Enter a URL..." value={originalUrl} onChange={(e) => {setOriginalUrl(e.target.value)}} />
                        <p>&nbsp;</p>
                        <button onClick={clickHandler}>Diminish</button>
                        <p>&nbsp;</p>
                        <a id="shortURL" href={`/${urlObj?.shortCode}`} target="_blank" rel="noopener noreferrer">{urlObj?.shortCode}</a>
                        <p>&nbsp;</p>
                        {
                          console.log(urlObj)
                        }
                        {
                          <img id="qrCode" />
                        }
                      </div>
                    }
                  />
                  <Route 
                    path="/:shortCode"
                    element={<Redirector />}
                  />
                </Routes>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    </Router>
  )
}

export default App
