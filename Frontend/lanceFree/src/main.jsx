import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import "./main.css"
import { Navbar } from './components/navbar/Navbar.jsx'
import { Body} from './components/body/Body.jsx'
import { Provider } from './components/providerDesc/Provider.jsx'
import { Service } from './components/serviceDesc/Service.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    {/*
    <Navbar></Navbar>
    <Body></Body>
    */}
    <Service>

    </Service>
  </React.StrictMode>
)
