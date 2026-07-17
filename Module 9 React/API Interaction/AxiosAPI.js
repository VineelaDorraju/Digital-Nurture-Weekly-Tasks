import React, { useEffect, useState } from "react";
import axios from "axios";

export default function AxiosAPI() {

    const [posts, setPosts] = useState([]);
    const [status, setStatus] = useState("idle");

    const getPosts = async () => {
        setStatus("loading");

        try {
            const res = await axios.get("https://jsonplaceholder.typicode.com/posts");
            setPosts(res.data.slice(0, 8));
            setStatus("success");
        } catch (err) {
            setStatus("error");
        }
    };

    useEffect(() => {
        getPosts();
    }, []);

    const renderStatus = () => {
        switch (status) {
            case "loading":
                return <p>Fetching posts...</p>;
            case "error":
                return <p style={{ color: "red" }}>Error loading posts</p>;
            default:
                return null;
        }
    };

    return (
        <div style={{ border: "1px solid #222", padding: "15px", margin: "10px" }}>
            <h2>Axios API Integration</h2>

            {renderStatus()}

            <div style={{ marginTop: "10px" }}>
                {posts.map(post => (
                    <div key={post.id} style={{ marginBottom: "10px" }}>
                        <h4>{post.title}</h4>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>

            <button onClick={getPosts}>
                Reload Posts
            </button>
        </div>
    );
}