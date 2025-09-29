// Login functionality
const loginForm = document.getElementById("loginForm")
const loginPage = document.getElementById("loginPage")
const dashboardContainer = document.getElementById("dashboardContainer")
const loginError = document.getElementById("loginError")

loginForm.addEventListener("submit", (e) => {
  e.preventDefault()
  const password = document.getElementById("password").value

  if (password === "Adm123Bruno") {
    loginPage.style.display = "none"
    dashboardContainer.style.display = "flex"
    loginError.classList.remove("show")
  } else {
    loginError.textContent = "Senha incorreta. Tente novamente."
    loginError.classList.add("show")
  }
})

// Navigation
const navItems = document.querySelectorAll(".nav-item")
const pages = document.querySelectorAll(".page")

navItems.forEach((item) => {
  item.addEventListener("click", (e) => {
    e.preventDefault()
    const targetPage = item.getAttribute("data-page")

    // Update active nav item
    navItems.forEach((nav) => nav.classList.remove("active"))
    item.classList.add("active")

    // Show target page
    pages.forEach((page) => page.classList.remove("active"))
    document.getElementById(targetPage + "Page").classList.add("active")
  })
})

// Logout
document.getElementById("logoutBtn").addEventListener("click", () => {
  dashboardContainer.style.display = "none"
  loginPage.style.display = "flex"
  document.getElementById("password").value = ""
})

// Guest Modal
function openGuestModal() {
  document.getElementById("guestModal").classList.add("show")
}

function closeGuestModal() {
  document.getElementById("guestModal").classList.remove("show")
}

// Reservation Modal
function openReservationModal() {
  document.getElementById("reservationModal").classList.add("show")
}

function closeReservationModal() {
  document.getElementById("reservationModal").classList.remove("show")
}

// Room Modal
function openRoomModal() {
  document.getElementById("roomModal").classList.add("show")
}

function closeRoomModal() {
  document.getElementById("roomModal").classList.remove("show")
}

// Close modal on outside click
document.querySelectorAll(".modal").forEach((modal) => {
  modal.addEventListener("click", (e) => {
    if (e.target === modal) {
      modal.classList.remove("show")
    }
  })
})

// CRUD Functions
function editGuest(id) {
  console.log("[v0] Editing guest:", id)
  alert("Função de editar hóspede #" + id + " será implementada aqui")
}

function deleteGuest(id) {
  if (confirm("Tem certeza que deseja excluir este hóspede?")) {
    console.log("[v0] Deleting guest:", id)
    alert("Hóspede #" + id + " excluído com sucesso!")
  }
}

function editReservation(id) {
  console.log("[v0] Editing reservation:", id)
  alert("Função de editar reserva #" + id + " será implementada aqui")
}

function deleteReservation(id) {
  if (confirm("Tem certeza que deseja cancelar esta reserva?")) {
    console.log("[v0] Deleting reservation:", id)
    alert("Reserva #" + id + " cancelada com sucesso!")
  }
}

function editRoom(id) {
  console.log("[v0] Editing room:", id)
  alert("Função de editar quarto #" + id + " será implementada aqui")
}

function deleteRoom(id) {
  if (confirm("Tem certeza que deseja excluir este quarto?")) {
    console.log("[v0] Deleting room:", id)
    alert("Quarto #" + id + " excluído com sucesso!")
  }
}

// Form submissions
document.querySelectorAll(".modal-form").forEach((form) => {
  form.addEventListener("submit", (e) => {
    e.preventDefault()
    alert("Dados salvos com sucesso!")
    document.querySelectorAll(".modal").forEach((modal) => {
      modal.classList.remove("show")
    })
    form.reset()
  })
})
