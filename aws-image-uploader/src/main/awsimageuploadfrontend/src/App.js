import React, {useState, useEffect, useCallback} from 'react';
import logo from './logo.svg';
import axios from "axios"
import './App.css';
import {useDropzone} from 'react-dropzone'

const UserProfiles = () => {
  const [userProfiles, setUserProfiles] = useState([]);
   
const fetchuserProfiles = () => {
  axios.get("http://localhost:8080/api/u1/user-profile").then(res => {
    console.log("defsef");
    setUserProfiles(res.data);
  });
};

useEffect(() => {
  fetchuserProfiles();
}, []);

return userProfiles.map((userprofile, i) => {
  return (
    <div key = {i}>
      <br/>
      <h1>{userprofile.username}</h1>
      <p>{userprofile.userProfileId}</p>
      <Dropzone userProfileId={userprofile.userProfileId}/>
      <br/>
    </div>
  );
});
};

//DropZone to upload files
function Dropzone({userProfileId}) {
  const onDrop = useCallback(acceptedFiles => {
    const file = acceptedFiles[0];
    const formdata = new FormData();
    formdata.append("file", file);
    console.log({userProfileId});
    axios.post(`http://localhost:8080/api/u1/user-profile/${userProfileId}/image/download`, 
    formdata,
    {
    headers: {
      "Content-Type": "multipart/form-data"
    }
  }
    ).then(() =>{
      console.log("File is uploaded")
    }).catch(error =>{
      console.log("Error: File not uploaded - ",error);
    })
  }, [])
  const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

  return (
    <div {...getRootProps()}>
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the files here ...</p> :
          <p>Drag 'n' drop some files here, or click to select files</p>
      }
    </div>
  )
}

//DropZone function end

function App() {
  return (
    <div className="App">
      <UserProfiles/>
    </div>
  );

  
}

export default App;
