import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import axios from 'axios';

const Redirector = () => {
    const [urlObj, setUrlObj] = useState(null);
    const { shortCode } = useParams();

    useEffect(() => {
        getHandler(shortCode);
    }, [])

    async function getHandler(code) {
        try {
            const response = await axios.get(`http://localhost:8080/url/${code}`);
            // if (!response.status != 200) {
            //     throw new Error("Bogus URL.");
            // }
            console.log(response.data);
            setUrlObj(response.data);
            } catch (error) {
            console.error("Nonexistent URL", error);
            alert("This URL doesn't exist.");
        }
    }

    return (
        <div>
            <h1>Redirector</h1>
            <h2>{urlObj ? window.location.href = urlObj.originalUrl : <>Loading...</>}</h2>
        </div>
    );
}

export default Redirector;